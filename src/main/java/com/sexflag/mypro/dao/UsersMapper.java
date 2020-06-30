package com.sexflag.mypro.dao;

import com.sexflag.mypro.pojo.Users;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsersMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> selectAll();

    int selectAllCount();
}