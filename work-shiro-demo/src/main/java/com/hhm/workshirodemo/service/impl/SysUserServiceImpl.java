package com.hhm.workshirodemo.service.impl;

import com.hhm.workshirodemo.dao.SysUserMapper;
import com.hhm.workshirodemo.domain.SysPermission;
import com.hhm.workshirodemo.domain.SysUser;
import com.hhm.workshirodemo.domain.UserInfo;
import com.hhm.workshirodemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ming
 * @create 2018-07-12 14:40
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public int insertSysUser(SysUser sysUser) {
        return 0;
    }

    @Override
    public List<SysUser> selectSysUserList() {
        return sysUserMapper.selectSysUserList();
    }

    @Override
    public SysUser selectSysUserByUid(int uid) {
        return null;
    }

    @Override
    public UserInfo selectUserInfoByUsernameAndPasswd(String username) {

        UserInfo userInfo = sysUserMapper.selectUserInfo(username);
        List<SysPermission> sysPermissionList = sysUserMapper.selectMenuList(userInfo.getUid());
        if (sysPermissionList != null && sysPermissionList.size() > 0){
            userInfo.setPermissionList(sysPermissionList);
        }
        return userInfo;
    }

}
