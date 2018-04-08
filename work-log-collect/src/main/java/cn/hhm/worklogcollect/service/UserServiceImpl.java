package cn.hhm.worklogcollect.service;

import cn.hhm.worklogcollect.dao.UserRepository;
import cn.hhm.worklogcollect.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务类
 * @outhor Ming
 * @create 2018-04-03 17:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public User selectOne(String username) {

        User user = userRepository.findByName(username);
        return user;
    }

    @Override
    public int delete(Long id) {
        userRepository.delete(id);
        return 1;
    }

    @Override
    public int update(User user) {
        userRepository.save(user);
        return 1;
    }

    @Override
    public List<User> selectUserList() {
        List<User> list = userRepository.findAll();
        return list;
    }
}
