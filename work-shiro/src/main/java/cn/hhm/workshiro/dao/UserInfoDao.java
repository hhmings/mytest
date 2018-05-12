package cn.hhm.workshiro.dao;

import cn.hhm.workshiro.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ming
 * @create 2018-04-26 17:59
 */
@Repository
public interface UserInfoDao extends JpaRepository<UserInfo,Integer> {

    UserInfo findUserInfoByUsername(String username);
}
