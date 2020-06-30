package com.sexflag.mypro.dao;

import com.sexflag.mypro.pojo.SysRole;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMapper {
    //查询一个角色信息以及所拥有的权限
    SysRole selectByRid(Integer rid);

    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}