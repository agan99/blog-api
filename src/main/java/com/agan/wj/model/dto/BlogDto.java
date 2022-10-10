package com.agan.wj.model.dto;

import com.agan.wj.entity.Category;
import com.agan.wj.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogDto {

    private Integer id;
    // 文章标题
    private String title;
    // 首图URL
    private String firstPicture;
    // 文章正文
    private String content;
    // 标签列表
    private List<Tag> tag;
    // 分类
    private Category category;

    // 页面展示层传输的分类对象：正常情况下为 字符串 或 分类id
    private Object cate;
    // 页面展示层传输的标签对象：正常情况下为 List<Integer>标签id 或 List<String>标签名
    private List<Object> tagList;
}
