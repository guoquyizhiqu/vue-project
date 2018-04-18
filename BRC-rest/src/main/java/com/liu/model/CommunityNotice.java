package com.liu.model;

import java.util.Date;

public class CommunityNotice {
    private String id;

    private String communityInfoId;

    private String content;

    private Date createTime;

    private Date updateTime;

    private String creater;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCommunityInfoId() {
        return communityInfoId;
    }

    public void setCommunityInfoId(String communityInfoId) {
        this.communityInfoId = communityInfoId == null ? null : communityInfoId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }
}