package com.liu.service;


import com.liu.model.BookUseRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by liu on 2018/3/26.
 */
public interface BookUseRecordService {
    Boolean add(BookUseRecord bookUseRecord);

    Boolean returnById(String id);

    Boolean edit(BookUseRecord bookUseRecord);

    Boolean deleteById(String id);

    BookUseRecord findById(String id);

    List<BookUseRecord> findAll(int pageNum, int pageSize, Map<String, Object> queryMap);
}
