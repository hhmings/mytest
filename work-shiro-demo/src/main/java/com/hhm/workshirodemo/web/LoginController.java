package com.hhm.workshirodemo.web;

import com.hhm.workshirodemo.domain.UserInfo;
import com.hhm.workshirodemo.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ming
 * @create 2018-07-12 15:12
 */
@Controller
public class LoginController {
    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysUserService sysUserService;


    @PostMapping("/login")
    public String login(HttpServletRequest request, String username, String passwd){

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username,passwd);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);

            UserInfo userInfo = sysUserService.selectUserInfoByUsernameAndPasswd(username);
            request.setAttribute("menuList",userInfo.getPermissionList());
        }catch (AuthenticationException e){
            e.printStackTrace();
            return "403";
        }
        return "index";
    }
}
