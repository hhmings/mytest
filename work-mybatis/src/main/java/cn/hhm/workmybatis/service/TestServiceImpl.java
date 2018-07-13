package cn.hhm.workmybatis.service;

import cn.hhm.workmybatis.dao.TestDao;
import cn.hhm.workmybatis.domain.Test1;
import cn.hhm.workmybatis.domain.Test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Ming
 * @create 2018-06-26 17:22
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;


    @Transactional
    @Override
    public void save() {

        Test1 test1 = new Test1();
        test1.setName("aa");
        Test2 test2 = new Test2();
        test2.setAge(18);

        testDao.saveTest1(test1);
        testDao.saveTest2(test2);
    }
}
