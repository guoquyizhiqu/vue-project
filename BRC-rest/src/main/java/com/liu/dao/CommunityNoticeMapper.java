package com.liu.dao;

import com.liu.model.CommunityNotice;

import java.util.List;

public interface CommunityNoticeMapper {

    Boolean save(CommunityNotice communityNotice);

    Boolean edit(CommunityNotice communityNotice);

    List<CommunityNotice> selectAll();

    boolean deleteById(String id);

    CommunityNotice selectByPrimaryKey(String id);


    int insert(CommunityNotice record);

    int insertSelective(CommunityNotice record);
}