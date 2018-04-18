package com.liu.dao;

import com.liu.model.CommunityInfo;

import java.util.List;

public interface CommunityInfoMapper {


    Boolean save(CommunityInfo communityInfo);

    Boolean edit(CommunityInfo communityInfo);

    List<CommunityInfo> selectAll();

    boolean deleteById(String id);

    CommunityInfo selectByPrimaryKey(String id);


    int deleteByPrimaryKey(String id);

    int insert(CommunityInfo record);

    int insertSelective(CommunityInfo record);

    int updateByPrimaryKeySelective(CommunityInfo record);

    int updateByPrimaryKey(CommunityInfo record);
}