package com.liu.controller;


import com.github.pagehelper.PageInfo;
import com.liu.model.CommunityInfo;
import com.liu.service.CommunityInfoService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * Created by liu on 2018/3/26.
 */
@RestController
@RequestMapping(value = "/community-info")
public class CommunityInfoController {

    @Autowired
    private CommunityInfoService communityInfoService;

    @ResponseBody
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String add(HttpServletRequest req, CommunityInfo communityInfo) {
        communityInfo.setCreateTime(new Date());
        communityInfoService.add(communityInfo);
        return "success";
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = {"application/json;charset=UTF-8"})
    public String edit(HttpServletRequest req, CommunityInfo communityInfo) {
        communityInfo.setUpdateTime(new Date());
        communityInfoService.edit(communityInfo);
        return "success";
    }


    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageInfo findAllCommunityInfo(int pageNum, int pageSize) {
        List<CommunityInfo> list = communityInfoService.findAll(pageNum, pageSize);
        return new PageInfo(list);
    }

    @RequestMapping(value = "/detail", produces = {"application/json;charset=UTF-8"})
    public CommunityInfo findCommunityInfo(String id) {
        CommunityInfo communityInfo = communityInfoService.findById(id);
        return communityInfo;
    }

    @ResponseBody
    @PostMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public String del(String id) {
        communityInfoService.deleteById(id);
        return "success";
    }
}