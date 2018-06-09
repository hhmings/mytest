package cn.hhm.workshiro.service;

import cn.hhm.workshiro.entity.UserInfo;
import org.apache.catalina.User;

import java.util.List;

/**
 * @author Ming
 * @create 2018-04-27 17:01
 */
public interface UserInfoService {
    UserInfo findByUsername(String username);

    int insertUserInfo(UserInfo userInfo);

    List<UserInfo> findUserInfoList();
}
