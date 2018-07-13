package com.hhm.workshirodemo.dao;

import com.hhm.workshirodemo.domain.SysPermission;
import com.hhm.workshirodemo.domain.SysUser;
import com.hhm.workshirodemo.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户
 *
 * @author Ming
 * @create 2018-07-12 14:36
 */
@Mapper
public interface SysUserMapper {

    @Select("select * from sys_user")
    List<SysUser> selectSysUserList();

    @Select("select * from sys_user where username=#{username}")
    UserInfo selectUserInfo(@Param("username") String username);

    //获取目录的显示
    List<SysPermission> selectMenuList(@Param("uid") int uid);

    //获取权限
    List<SysPermission> selectSysPermissionList(@Param("uid") int uid);
}
