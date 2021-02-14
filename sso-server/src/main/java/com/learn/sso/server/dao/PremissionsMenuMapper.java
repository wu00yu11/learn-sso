package com.learn.sso.server.dao;

import com.learn.sso.server.model.PremissionsMenu;

public interface PremissionsMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PremissionsMenu record);

    int insertSelective(PremissionsMenu record);

    PremissionsMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PremissionsMenu record);

    int updateByPrimaryKey(PremissionsMenu record);
}