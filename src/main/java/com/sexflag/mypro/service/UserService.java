package com.sexflag.mypro.service;

import com.sexflag.mypro.pojo.PageBean;
import com.sexflag.mypro.pojo.SysUser;
import com.sexflag.mypro.pojo.Users;

import java.util.List;

public interface UserService {

    SysUser selectByName(String name);

    List<Users> selectAll();
    PageBean<Users> selectAllPage(Integer currentPage, Integer pagesize);

    Users selectUserById(int value);
}
