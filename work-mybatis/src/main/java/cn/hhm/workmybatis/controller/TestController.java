package cn.hhm.workmybatis.controller;

import cn.hhm.workmybatis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ming
 * @create 2018-06-26 17:20
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public void test(){
        testService.save();
    }

}
