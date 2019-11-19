package com.anoyi.douyin.mapper;

import java.util.List;

import com.anoyi.douyin.entity.Role;
import com.anoyi.douyin.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<Role> selectRoleByUserId(Integer id);
}