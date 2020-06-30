package com.sexflag.mypro.dao;

import com.sexflag.mypro.pojo.DemUser;
import org.springframework.stereotype.Repository;

@Repository
public interface DemUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DemUser record);

    int insertSelective(DemUser record);

    DemUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DemUser record);

    int updateByPrimaryKey(DemUser record);
}