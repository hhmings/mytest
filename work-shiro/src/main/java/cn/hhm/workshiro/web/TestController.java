package cn.hhm.workshiro.web;

import cn.hhm.workshiro.entity.UserInfo;
import cn.hhm.workshiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ming
 * @create 2018-06-01 15:18
 */
@RestController
public class TestController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/addUser")
    public String add(UserInfo userInfo){
        userInfo.setPasswrod("123");
        userInfo.setSalt("abc");
        userInfo.setState((byte)0);
        userInfoService.insertUserInfo(userInfo);
        return "200";
    }

}
