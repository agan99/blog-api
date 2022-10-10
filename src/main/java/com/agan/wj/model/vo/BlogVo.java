package com.agan.wj.model.vo;

import com.agan.wj.entity.Blog;
import com.agan.wj.entity.Category;
import com.agan.wj.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogVo {

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
    private String categoryName;

    private Date createTime;

    private Date updateTime;

}
