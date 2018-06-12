package com.hhm.workswagger.controller;

import com.hhm.workswagger.dao.PersonJpa;
import com.hhm.workswagger.domain.Person;
import com.hhm.workswagger.domain.PersonVO;
import com.hhm.workswagger.domain.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author Ming
 * @create 2018-06-09 10:40
 */
@RestController
@Api(value = "/person", tags = "我的接口模块")
public class PersonController {

    @Autowired
    PersonJpa personJpa;

    private Logger log = LoggerFactory.getLogger(PersonController.class);


    @ApiOperation(value = "添加Person", response = String.class)
    @PostMapping("/insert")
    public String insertUser(@RequestBody Person person) {
        log.error("Person信息：" + person.toString());

//        Person p = new Person();
//        p.setCreate_time(person.getCreate_time());

        Person save = personJpa.save(person);
        log.error("save Person信息：" + save.toString());

        return "添加成功";
    }

    @ApiOperation(value = "查询Person")
    @GetMapping("/query")
    public List<Person> queryUser() {
        List<Person> list = personJpa.findAll();
        log.error("Person信息：" + list.toString());
        return list;
    }



}
