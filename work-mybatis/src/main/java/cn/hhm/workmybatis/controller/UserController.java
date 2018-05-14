package cn.hhm.workmybatis.controller;

import cn.hhm.workmybatis.domain.User;
import cn.hhm.workmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ming
 * @create 2018-05-14 14:24
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/get")
    public User findUserById(Integer id){
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public List<User> findUserList(Integer page){
        return userService.findUserList(page);
    }
}
