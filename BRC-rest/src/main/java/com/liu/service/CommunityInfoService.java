package com.liu.service;


import com.liu.model.CommunityInfo;

import java.util.List;

/**
 * Created by liu on 2018/3/26.
 */
public interface CommunityInfoService {
    Boolean add(CommunityInfo communityInfo);

    Boolean edit(CommunityInfo communityInfo);

    Boolean deleteById(String id);

    CommunityInfo findById(String id);

    List<CommunityInfo> findAll(int pageNum, int pageSize);
}
