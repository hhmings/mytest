package cn.hhm.worklogcollect.controller;

import cn.hhm.worklogcollect.aop.EnableLog;
import cn.hhm.worklogcollect.entity.User;
import cn.hhm.worklogcollect.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @outhor Ming
 * @create 2018-04-03 17:16
 */
@Controller
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String name, HttpServletRequest request) throws ServletException, IOException {
        User user = userService.selectOne(name);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return "index";
        }
        return "login";
    }

    @EnableLog(desc = "用户列表")
    @GetMapping("/user_list")
    public ModelAndView index(ModelAndView model) throws Exception {

        List<User> userList = userService.selectUserList();
        model.addObject("userList", userList);
        model.setViewName("user_list");
        return model;
    }
}
