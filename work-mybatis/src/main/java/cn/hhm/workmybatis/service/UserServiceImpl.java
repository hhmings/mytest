package cn.hhm.workmybatis.service;

import cn.hhm.workmybatis.dao.UserDao;
import cn.hhm.workmybatis.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ming
 * @create 2018-05-14 14:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> findUserList(int page) {
        PageHelper.startPage(page,5);
        return userDao.findUserList();
    }
}
