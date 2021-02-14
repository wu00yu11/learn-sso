package com.learn.sso.server.dao;

import com.learn.sso.server.model.RolePremissions;

public interface RolePremissionsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RolePremissions record);

    int insertSelective(RolePremissions record);

    RolePremissions selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePremissions record);

    int updateByPrimaryKey(RolePremissions record);
}