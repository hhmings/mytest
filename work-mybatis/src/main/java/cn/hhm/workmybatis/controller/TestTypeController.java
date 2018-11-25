package cn.hhm.workmybatis.controller;

import cn.hhm.workmybatis.dao.TestTypeMapper;
import cn.hhm.workmybatis.domain.TestType;
import cn.hhm.workmybatis.enums.TestTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ming
 * @create 2018-11-25 19:21
 */
@RestController
public class TestTypeController {

    @Autowired
    private TestTypeMapper testTypeMapper;

    @GetMapping("/type/test1")
    public String test1(){
        TestType testType = new TestType();
        testType.setTestTypeEnum(TestTypeEnum.beijing);
        testTypeMapper.insert(testType);

        TestType testType1 = new TestType();
        testType1.setTestTypeEnum(TestTypeEnum.shanghai);
        testTypeMapper.insert(testType1);

        return "ok";
    }

    @GetMapping("/type/test2")
    public  List<TestType> select(){
        List<TestType> testTypes = testTypeMapper.selectList(TestTypeEnum.shanghai);

        testTypes.forEach(t-> System.out.println(t.toString()));

        return testTypes;
    }

}
