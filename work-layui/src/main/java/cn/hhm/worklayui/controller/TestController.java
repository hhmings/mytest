package cn.hhm.worklayui.controller;

import cn.hhm.worklayui.domain.LeftNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ming
 * @create 2018-05-25 16:14
 */
@Controller
public class TestController {

    private Logger log = LoggerFactory.getLogger(TestController.class);


    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }

    @GetMapping(value = "/{page}")
    public String page(@PathVariable  String page){
        return page;
    }

}
