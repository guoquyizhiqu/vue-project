package com.liu.dao;

import com.liu.model.User;

import java.util.List;

public interface UserMapper {
    boolean insertSelective(User user);

    List<User> selectAllUser();

    /*  @Select("SELECT * FROM user WHERE id = #{id}")*/
    User findById(String id);
}