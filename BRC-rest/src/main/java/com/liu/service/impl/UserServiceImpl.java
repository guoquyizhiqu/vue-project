package com.liu.service.impl;

import com.github.pagehelper.PageHelper;
import com.liu.dao.UserMapper;
import com.liu.model.User;
import com.liu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liu on 2018/1/9.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userDao;

    @Override
    public Boolean addUser(User user) {
        int flag = userDao.insertSelective(user);

        return true;
    }

    @Override
    public User findById(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userDao.selectAllUser();

        return list;
    }}
