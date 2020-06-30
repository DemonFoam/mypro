package com.sexflag.mypro.dao;

import com.sexflag.mypro.pojo.SysPermission;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer permId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer permId);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}