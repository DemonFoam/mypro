package com.sexflag.mypro.service.impl;

import com.github.pagehelper.PageHelper;
import com.sexflag.mypro.dao.SysUserMapper;
import com.sexflag.mypro.dao.UsersMapper;
import com.sexflag.mypro.pojo.PageBean;
import com.sexflag.mypro.pojo.SysUser;
import com.sexflag.mypro.pojo.Users;
import com.sexflag.mypro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectByName(String name) {
        return sysUserMapper.selectByUsername(name);
    }

    @Override
    public List<Users> selectAll() {
        return usersMapper.selectAll();
    }

    @Override
    public PageBean<Users> selectAllPage(Integer currentPage, Integer pagesize) {
        try {
            PageBean<Users> entity = new PageBean();
            if (null != pagesize) {
                entity.setPageSize(pagesize);
            }
            if (null != currentPage) {
                entity.setCurrentPage(currentPage);
            }
            PageHelper.startPage(entity.getCurrentPage(), entity.getPageSize());
            List<Users> list = usersMapper.selectAll();
            Integer count = usersMapper.selectAllCount();
            entity.setItems(list);
            entity.setTotalNum(count);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Users selectUserById(int value) {
        System.out.println(usersMapper);
        return usersMapper.selectByPrimaryKey(value);
    }
}
