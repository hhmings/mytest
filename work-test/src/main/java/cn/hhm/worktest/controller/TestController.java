package cn.hhm.worktest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 并发测试 -- demo
 *
 * @author Ming
 * @create 2018-05-24 10:46
 */
@RestController
public class TestController {

    private Logger log = LoggerFactory.getLogger(TestController.class);

    private static final ReentrantLock lock = new ReentrantLock();

String a = new String();
    private long num = 50;

    @GetMapping(value = "/test2")
    public void test2(){
        if (num <=0){
            log.error("没有抢到的线程-->  "+Thread.currentThread().getName()+"   ---  "+num);
            return;
        }
        synchronized (TestController.this){
            if (num > 0){
                log.error("线程-->  "+Thread.currentThread().getName()+"   编号---  "+num);
                num--;
            }
        }
    }

    @GetMapping(value = "/test")
    public void test1(){

        try {
            lock.lock();
            if (num > 0){
                log.error("线程-->  "+Thread.currentThread().getName()+"   编号---  "+num);
                num--;
            }else {
                log.error("没有抢到的线程-->  "+Thread.currentThread().getName()+"   ---  "+num);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
