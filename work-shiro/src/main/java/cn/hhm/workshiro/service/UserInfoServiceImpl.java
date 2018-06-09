package cn.hhm.workshiro.service;

import cn.hhm.workshiro.dao.UserInfoDao;
import cn.hhm.workshiro.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ming
 * @create 2018-04-27 17:02
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        UserInfo userInfo = userInfoDao.findUserInfoByUsername(username);
        return userInfo;
    }

    @Override
    public int insertUserInfo(UserInfo userInfo) {

        userInfoDao.save(userInfo);
        return 1;
    }

    @Override
    public List<UserInfo> findUserInfoList() {
        List<UserInfo> list = userInfoDao.findAll();
        System.out.println(" List<UserInfo> list = "+list.size());
        return list;
    }
}
