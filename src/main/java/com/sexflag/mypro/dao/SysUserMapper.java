package com.sexflag.mypro.dao;

import com.sexflag.mypro.pojo.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
    //用户登录权限验证
    SysUser selectByUsername(String name);

    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}