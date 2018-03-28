package com.liu.service;

import com.liu.model.User;

import java.util.List;

/**
 * Created by liu on 2018/1/9.
 */
public interface UserService {
    Boolean addUser(User user);

    User findById(String id);
    List<User> findAllUser(int pageNum, int pageSize);
}
