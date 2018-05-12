package cn.hhm.workshiro.service;

import cn.hhm.workshiro.entity.UserInfo;

/**
 * @author Ming
 * @create 2018-04-27 17:01
 */
public interface UserInfoService {
    UserInfo findByUsername(String username);
}
