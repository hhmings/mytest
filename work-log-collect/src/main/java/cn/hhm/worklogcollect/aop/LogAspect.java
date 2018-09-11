package cn.hhm.worklogcollect.aop;

import cn.hhm.worklogcollect.entity.MyLog;
import cn.hhm.worklogcollect.entity.User;
import cn.hhm.worklogcollect.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志切面类
 *
 * @outhor Ming
 * @create 2018-04-04 8:51
 */
//@Component
//@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private static final ThreadLocal<User> userThreadLocal = new NamedThreadLocal<>("threadlocal_user");
    private static final ThreadLocal<MyLog> myLogThreadLocal = new NamedThreadLocal<>("threadlocal_myLog");

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private LogService logService;

    /**
     * 在controller的切点
     */
    @Pointcut(value = "@annotation(cn.hhm.worklogcollect.aop.EnableLog)")
    public void controllerPointCut() {
    }

    /**
     * 前置通知
     *
     * @param point
     */
    @Before(value = "controllerPointCut()")
    public void doBefore(JoinPoint point) throws Exception {
        logger.error("前置通知...执行");
        Date beginTime = new Date();//操作时间
        MyLog myLog = new MyLog();
        myLog.setTime(beginTime);

        //获取用户
        HttpServletRequest request = getRequest();
        User user = (User) request.getSession().getAttribute("user");
        myLogThreadLocal.set(myLog);
        userThreadLocal.set(user);
    }

    /**
     * 后置通知
     *
     * @param point
     */
    @After(value = "controllerPointCut()")
    public void doAfter(JoinPoint point) {
        logger.error("后置通知...执行");
        User user = userThreadLocal.get();
        if (user != null) {
            String title = "";

            HttpServletRequest request = getRequest();
            String ip = request.getRemoteAddr();
            String uri = request.getRequestURI();
            String requestType = request.getMethod();

            StringBuilder sb = new StringBuilder();
            sb.append("URI:").append(request.getRequestURI());
            sb.append("最大内存:").append(Runtime.getRuntime().maxMemory() / 1024 / 1024).append("m");
            sb.append("已分配内存:").append(Runtime.getRuntime().maxMemory() / 1024 / 1024).append("m");
            sb.append("已分配内存中的剩余空间:").append(Runtime.getRuntime().freeMemory() / 1024 / 1024).append("m");
            sb.append("最大可用内存:").append((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory()) / 1024 / 1024).append("m");

            logger.error(sb.toString());

            try {
                title = getDesc(point);
            } catch (Exception e) {
                e.printStackTrace();
            }
            MyLog myLog = myLogThreadLocal.get();
            myLog.setType("info");
            myLog.setTitle(title);
            myLog.setIpAddress(ip);
            myLog.setUriStr(uri);
            myLog.setRequestType(requestType);
            myLog.setUserId(user.getId().toString());
            myLog.setCreateTime(new Date());
            myLogThreadLocal.set(myLog);
            //通过线程池保存日志
            threadPoolTaskExecutor.execute(new InsertLogThread(myLog, logService));
            userThreadLocal.remove();
        }
    }

    /**
     *在 @After之后执行，如果没有异常的话，最终执行本方法
     * @param point
     */
    @AfterReturning("controllerPointCut()")
    public void doAfterReturning(JoinPoint point){
        logger.error("AfterReturning...........执行");
        myLogThreadLocal.remove();

    }

    /**
     * 异常通知
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "controllerPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.error("AfterThrowing通知...执行");
        MyLog myLog = myLogThreadLocal.get();
        if (myLog != null) {
            myLog.setType("error");
            myLog.setErrorInfo(e.toString());
            threadPoolTaskExecutor.execute(new UpdateLogThread(myLog, logService));
            myLogThreadLocal.remove();
        }
    }

    /**
     * 日志的保存
     */
    private class InsertLogThread implements Runnable {

        private MyLog myLog;
        private LogService logService;

        public InsertLogThread(MyLog myLog, LogService logService) {
            this.myLog = myLog;
            this.logService = logService;
        }

        @Override
        public void run() {
            logService.insert(myLog);
        }
    }

    /**
     * 日志的更新
     */
    private class UpdateLogThread implements Runnable {

        private MyLog myLog;
        private LogService logService;

        public UpdateLogThread(MyLog myLog, LogService logService) {
            this.myLog = myLog;
            this.logService = logService;
        }

        @Override
        public void run() {
            logService.update(myLog);
        }
    }

    public String getDesc(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        EnableLog enableLog = method.getAnnotation(EnableLog.class);
        String desc = enableLog.desc();
        return desc;
    }

    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request;
    }
}
