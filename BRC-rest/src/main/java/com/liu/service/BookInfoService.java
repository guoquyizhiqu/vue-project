package com.liu.service;

import com.liu.model.BookInfo;

import java.util.List;

/**
 * Created by liu on 2018/3/26.
 */
public interface BookInfoService {
    Boolean addBookInfo(BookInfo bookInfo);

    BookInfo findById(String id);
    List<BookInfo> findAllBookInfo(int pageNum, int pageSize);
}
