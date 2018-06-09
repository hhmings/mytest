package cn.hhm.workshiro.dao;

import cn.hhm.workshiro.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Ming
 * @create 2018-04-26 17:59
 */
@Repository
public interface UserInfoDao extends JpaRepository<UserInfo,Integer> {

    UserInfo findUserInfoByUsername(String username);

}
