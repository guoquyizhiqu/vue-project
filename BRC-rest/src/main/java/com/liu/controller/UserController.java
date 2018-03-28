package com.liu.controller;


import com.github.pagehelper.PageInfo;
import com.liu.model.User;
import com.liu.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liu on 2018/8/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String addUser(HttpServletRequest req, User user) {
        userService.addUser(user);
        return "success";
    }

    @RequestMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
    public String test(HttpServletRequest req, User user) {
        System.out.println("-----test---------");
        return "success";
    }

    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageInfo findAllUser(int pageNum, int pageSize, String aa) {
        System.out.print("-------findAllUser--------------------------->");
        List<User> list = userService.findAllUser(pageNum, pageSize);
        return new PageInfo(list);
       /* return new PageInfo();*/
    }
}