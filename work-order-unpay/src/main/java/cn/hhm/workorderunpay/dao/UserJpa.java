package cn.hhm.workorderunpay.dao;

import cn.hhm.workorderunpay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Ming
 * @create 2018-04-13 14:19
 */
public interface UserJpa extends JpaRepository<User,Integer> {

    @Transactional
    @Modifying
    @Query("update User set name=?2 where id=?1")
    int updateUserInfo(Integer id,String s);

    @Query("select id,sid,name,pwd  from User")
    List<User> userList();
}
