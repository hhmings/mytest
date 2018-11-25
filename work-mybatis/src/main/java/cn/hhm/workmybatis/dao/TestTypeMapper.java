package cn.hhm.workmybatis.dao;

import cn.hhm.workmybatis.domain.TestType;
import cn.hhm.workmybatis.enums.TestTypeEnum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ming
 * @create 2018-11-25 15:41
 */
@Mapper
public interface TestTypeMapper {

    int insert(TestType testType);

    List<TestType> selectList(TestTypeEnum testTypeEnum);

}
