package com.hhm.workswagger.controller;

import com.hhm.workswagger.domain.UserVO;
import com.hhm.workswagger.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * http://127.0.0.1:8080/swagger-ui.html
 *
 * @author Ming
 * @create 2018-06-09 8:58
 */
@Api(value = "/test",tags = "测试接口模块")
@RestController
@RequestMapping("/test")
public class TestController {

    private Logger log = LoggerFactory.getLogger(TestController.class);


    @Autowired
    TestService testService;

    @ApiOperation(value = "查询操作",response = String.class)
    @GetMapping("/query")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType = "String",name = "id",value = "学生id",required = true)
    })
    public String query(String id){
        return "return data list";
    }

    /**
     * 删除操作
     * @return
     */
    @ApiOperation(value = "删除操作",response = String.class)
    @GetMapping("/delete")
    public String del(){
        return "ok";
    }

    @ApiOperation(value = "添加用户",response = String.class)

    @PostMapping("/insert")
    public String insertUser(@RequestBody UserVO userVO){
        log.error("用户信息："+userVO.toString());

        return "添加成功";
    }

}
