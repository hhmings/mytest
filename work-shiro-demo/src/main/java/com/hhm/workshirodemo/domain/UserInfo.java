package com.hhm.workshirodemo.domain;

import java.util.List;

/**
 * user转换
 *
 * @author Ming
 * @create 2018-07-12 15:29
 */
public class UserInfo extends SysUser {
    private List<SysRole> roleList;
    private List<SysPermission> permissionList;

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public List<SysPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SysPermission> permissionList) {
        this.permissionList = permissionList;
    }
}
