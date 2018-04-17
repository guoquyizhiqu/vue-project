package com.liu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BookInfo {
    private String id;

    private String bookName;

    private String publisher;

    private String publishTime;

    private String author;

    private Float price;

    private Date createTime;

    private Date updateTime;

    private String bookType;

    private String creater;

    private Integer borrowingStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType == null ? null : bookType.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Integer getBorrowingStatus() {
        return borrowingStatus;
    }

    public void setBorrowingStatus(Integer borrowingStatus) {
        this.borrowingStatus = borrowingStatus;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishTime=" + publishTime +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", bookType='" + bookType + '\'' +
                ", creater='" + creater + '\'' +
                ", borrowingStatus=" + borrowingStatus +
                '}';
    }
}