package com.learn.sso.server.dao;

import com.learn.sso.server.model.Premissions;

public interface PremissionsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Premissions record);

    int insertSelective(Premissions record);

    Premissions selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Premissions record);

    int updateByPrimaryKey(Premissions record);
}