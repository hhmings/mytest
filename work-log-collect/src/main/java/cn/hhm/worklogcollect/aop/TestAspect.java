package cn.hhm.worklogcollect.aop;

import cn.hhm.worklogcollect.entity.MyLog;
import cn.hhm.worklogcollect.entity.User;
import cn.hhm.worklogcollect.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
@Component
@Aspect
public class TestAspect {

    private static final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private LogService logService;

    /**
     * 在controller的切点
     */
    @Pointcut(value = "@annotation(cn.hhm.worklogcollect.aop.ITest)")
    public void controllerPointCut() {
    }

    /**
     * 前置通知：在目标方法调用之前执行
     *
     * @param point
     */
    @Before(value = "controllerPointCut()")
    public void doBefore(JoinPoint point) throws Exception {
        logger.error("beore..........执行");
    }

    /**
     * 后置通知：在目标方法调用之后执行
     *
     * @param point
     */
    @After(value = "controllerPointCut()")
    public void doAfter(JoinPoint point) {
        logger.error("after..........执行");
    }

    /**
     *在 @After之后执行，如果没有异常的话，最终执行本方法
     * @param point
     */
    @AfterReturning("controllerPointCut()")
    public void doAfterReturning(JoinPoint point){
        logger.error("AfterReturning...........执行");
    }

    @Around("@annotation(iTest)")
    public Object doAround(ProceedingJoinPoint point,ITest iTest) throws Throwable {
        logger.error("Around..before.........执行");

        Object obj = null;
        String desc = iTest.desc();
        logger.error("注解内容........."+desc);

            obj = point.proceed();
            logger.error("Around..after.........执行");
        return obj;
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
    }

}
