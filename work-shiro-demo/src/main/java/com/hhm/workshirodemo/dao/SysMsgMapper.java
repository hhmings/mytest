package com.hhm.workshirodemo.dao;

import com.hhm.workshirodemo.domain.SysMsg;
import com.hhm.workshirodemo.domain.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ming
 * @create 2018-07-12 14:59
 */
@Mapper
public interface SysMsgMapper {

    int insertMsg(SysMsg sysMsg);

    int deleteMsg(int id);

    int updateMsg(SysMsg sysMsg);

    @Select("select * from sys_msg")
    List<SysMsg> selectMsgList();

    //查询权限
    List<SysPermission> getPermissionList(int uid);

}
