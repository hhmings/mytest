package cn.hhm.workshiro.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Ming
 * @create 2018-05-31 16:03
 */
@Controller
public class HomeController {

    private Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping({"/","/index"})
    public String index(){
        return "/index";
    }


    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String login(String username, String password) throws Exception {

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username,password );
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            return "index";
        }catch (AuthenticationException e){
            e.printStackTrace();
            return "403";
        }
    }
}
