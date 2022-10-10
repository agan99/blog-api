package com.agan.wj.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private Integer id;

    private String title;

    private String firstPicture;

    private String content;

//    private String description;
    // 公开 私密
//    private Integer isPublished;
    // 评论开关
//    private Integer isCommentEnabled;

    private Date createTime;

    private Date updateTime;
    // 游览次数
//    private Integer views;

    private Integer categoryId;
    // 是否置顶
//    private Integer isTop;
}
