package cn.hhm.workmybatis.dao;

import cn.hhm.workmybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ming
 * @create 2018-05-14 14:20
 */
@Mapper
public interface UserDao {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findUserById(@Param("id") int id);

    List<User> findUserList();
}
