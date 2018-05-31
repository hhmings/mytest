package cn.hhm.worklayui.controller;

import cn.hhm.worklayui.domain.Result;
import cn.hhm.worklayui.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ming
 * @create 2018-05-26 14:27
 */
@RestController
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/user/list")
    public Result getUserList(Integer page,Integer rows){

        log.error("page = "+page+" , rows = "+rows);
        return new Result(200,"ok",100,null);
    }
}
