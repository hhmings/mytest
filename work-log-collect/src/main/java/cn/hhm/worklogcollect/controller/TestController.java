package cn.hhm.worklogcollect.controller;

import cn.hhm.worklogcollect.aop.EnableLog;
import cn.hhm.worklogcollect.aop.ITest;
import cn.hhm.worklogcollect.entity.User;
import cn.hhm.worklogcollect.service.TestService;
import cn.hhm.worklogcollect.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @outhor Ming
 * @create 2018-04-03 17:16
 */
@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;


    @GetMapping("/test1")
    public String mytest1() {
        testService.test1();
        return "test1";
    }

    @GetMapping("/test2")
    public String mytest2() {
        testService.test2();
        return "test2";
    }
}
