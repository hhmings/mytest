package cn.hhm.worklogcollect.service;

import cn.hhm.worklogcollect.aop.ITest;
import org.springframework.stereotype.Service;

/**
 * @author Ming
 * @create 2018-07-30 15:28
 */
@Service
public class TestServiceImpl implements TestService {

    @ITest(desc = "测试test1")
    @Override
    public void test1() {
        System.out.println("test1......");
    }
    @ITest(desc = "测试test2")
    @Override
    public void test2() {
        int i = 10/0;
        System.out.println("test2......");
    }
}
