package com.hhm.workshirodemo.service;

import com.hhm.workshirodemo.domain.SysPermission;
import com.hhm.workshirodemo.domain.SysUser;
import com.hhm.workshirodemo.domain.UserInfo;

import java.util.List;

/**
 * @author Ming
 * @create 2018-07-12 14:40
 */
public interface SysUserService {

    //添加用户
    int insertSysUser(SysUser sysUser);

    //查询所有用户
    List<SysUser> selectSysUserList();

    //查询单个用户
    SysUser selectSysUserByUid(int uid);

    UserInfo selectUserInfoByUsernameAndPasswd(String username);

}
