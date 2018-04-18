package com.liu.service;


import com.liu.model.Reader;

import java.util.List;

/**
 * Created by liu on 2018/3/26.
 */
public interface ReaderService {
    Boolean add(Reader reader);

    Boolean edit(Reader reader);

    Boolean deleteById(String id);

    Reader findById(String id);

    List<Reader> findAll(int pageNum, int pageSize);
}
