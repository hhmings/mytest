package com.hhm.workshirodemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ming
 * @create 2018-07-12 16:01
 */
@Controller
public class SysUserController {

    @GetMapping("/user/page")
    public String userPage(){
        return "user_list";
    }
}
