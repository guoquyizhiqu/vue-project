package com.liu.service;


import com.liu.model.CommunityNotice;

import java.util.List;

/**
 * Created by liu on 2018/3/26.
 */
public interface CommunityNoticeService {
    Boolean add(CommunityNotice communityNotice);

    Boolean edit(CommunityNotice communityNotice);

    Boolean deleteById(String id);

    CommunityNotice findById(String id);

    List<CommunityNotice> findAll(int pageNum, int pageSize);
}
