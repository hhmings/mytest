package cn.hhm.worklogcollect.controller;

import cn.hhm.worklogcollect.aop.EnableLog;
import cn.hhm.worklogcollect.entity.User;
import cn.hhm.worklogcollect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户web层
 * @outhor Ming
 * @create 2018-04-03 17:14
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @EnableLog(desc = "用户模块-添加")
    @GetMapping(value = "/user/insert")
    public String insert(String name){

        User user = new User();
        user.setName(name);
        userService.insert(user);
        return "ok";
    }

    @EnableLog(desc = "用户模块-删除")
    @GetMapping(value = "/user/delete")
    public String delete(Long id){
        userService.delete(id);
        return "ok";
    }

    @EnableLog(desc = "用户模块-更新")
    @GetMapping(value = "/user/update")
    public String update(){
        User user = userService.selectOne("user_2");
        user.setName("user_2_update");
        userService.update(user);
        return "ok";
    }

    @EnableLog(desc = "用户模块-查询列表")
    @GetMapping(value = "/user/list")
    public List<User> userList(){

        List<User> userList = userService.selectUserList();
        return userList;
    }
}
