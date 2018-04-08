package cn.hhm.worklogcollect.service;

import cn.hhm.worklogcollect.entity.User;

import java.util.List;

/**
 * 用户业务类
 * @outhor Ming
 * @create 2018-04-03 17:09
 */
public interface UserService {
    void insert(User user);

    User selectOne(String username);
    int delete(Long id);
    int update(User user);
    List<User> selectUserList();
}
