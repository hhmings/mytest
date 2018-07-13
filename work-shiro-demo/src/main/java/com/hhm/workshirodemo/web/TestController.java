package com.hhm.workshirodemo.web;

import com.hhm.workshirodemo.domain.SysUser;
import com.hhm.workshirodemo.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.function.Consumer;

/**
 * 测试controller
 * @author Ming
 * @create 2018-07-12 11:33
 */
@Controller
public class TestController {
    private Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/login")
    public String test(){
        return "login";
    }
}
