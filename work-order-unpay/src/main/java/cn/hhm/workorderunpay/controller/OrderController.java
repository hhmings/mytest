package cn.hhm.workorderunpay.controller;

import cn.hhm.workorderunpay.dao.UserJpa;
import cn.hhm.workorderunpay.entity.User;
import cn.hhm.workorderunpay.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ming
 * @create 2018-04-13 14:33
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserJpa userJpa;

    @GetMapping("/create")
    public String index(){
        User user = null;

        for (int i = 0; i <10 ; i++) {
            user = new User();
            user.setName("zhangsan"+i);
            user.setSid(100D);
            user.setPwd("abc"+i);
            orderService.createOrder(user);
        }
        return "ok";
    }

    @GetMapping("/list")
    public List<User> getUserList(){
        List<User> users = userJpa.userList();
        return users;
    }
}
