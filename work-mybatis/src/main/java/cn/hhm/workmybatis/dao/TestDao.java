package cn.hhm.workmybatis.dao;

import cn.hhm.workmybatis.domain.Test1;
import cn.hhm.workmybatis.domain.Test2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Ming
 * @create 2018-06-26 17:21
 */
@Mapper
public interface TestDao {

    int saveTest1(Test1 test1);

    int saveTest2(Test2 test2);


    List<Test1> getTest1List();
}
