package cn.hhm.workmybatis.service;

import cn.hhm.workmybatis.domain.User;

import java.util.List;

/**
 * @author Ming
 * @create 2018-05-14 14:22
 */
public interface UserService {
    User findUserById(int id);

    List<User> findUserList(int page);
}
