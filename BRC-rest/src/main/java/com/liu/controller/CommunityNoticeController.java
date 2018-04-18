package com.liu.controller;


import com.github.pagehelper.PageInfo;
import com.liu.model.CommunityNotice;
import com.liu.service.CommunityNoticeService;
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
@RequestMapping(value = "/community-notice")
public class CommunityNoticeController {

    @Autowired
    private CommunityNoticeService communityNoticeService;

    @ResponseBody
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String add(HttpServletRequest req, CommunityNotice communityNotice) {
        communityNotice.setCreateTime(new Date());
        communityNoticeService.add(communityNotice);
        return "success";
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = {"application/json;charset=UTF-8"})
    public String edit(HttpServletRequest req, CommunityNotice communityNotice) {
        communityNotice.setUpdateTime(new Date());
        communityNoticeService.edit(communityNotice);
        return "success";
    }


    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageInfo findAllCommunityNotice(int pageNum, int pageSize) {
        List<CommunityNotice> list = communityNoticeService.findAll(pageNum, pageSize);
        return new PageInfo(list);
    }

    @RequestMapping(value = "/detail", produces = {"application/json;charset=UTF-8"})
    public CommunityNotice findCommunityNotice(String id) {
        CommunityNotice communityNotice = communityNoticeService.findById(id);
        return communityNotice;
    }

    @ResponseBody
    @PostMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public String del(String id) {
        communityNoticeService.deleteById(id);
        return "success";
    }
}