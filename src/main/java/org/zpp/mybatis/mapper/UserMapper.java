package org.zpp.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import org.zpp.mybatis.model.SysUser;

import java.util.List;

public interface UserMapper {

    @Select("SELECT user_id,username FROM sys_user where user_id <=10")
    List<SysUser> list();
} 