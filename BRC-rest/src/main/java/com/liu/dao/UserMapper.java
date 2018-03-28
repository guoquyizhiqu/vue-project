package com.liu.dao;

import com.liu.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    boolean insertSelective(User user);

    List<User> selectAllUser();

    /*  @Select("SELECT * FROM user WHERE id = #{id}")*/
    User findById(String id);
}