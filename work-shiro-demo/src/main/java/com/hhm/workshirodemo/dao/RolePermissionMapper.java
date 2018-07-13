package com.hhm.workshirodemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Ming
 * @create 2018-07-13 13:56
 */
@Mapper
public interface RolePermissionMapper {

    int updateInfo(@Param("id") int id);
}
