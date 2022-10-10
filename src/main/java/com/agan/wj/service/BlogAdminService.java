package com.agan.wj.service;

import com.agan.wj.base.AjaxResponse;
import com.agan.wj.entity.Blog;
import com.agan.wj.model.dto.BlogDto;
import com.agan.wj.model.dto.QueryBlogDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;

public interface BlogAdminService {

    /**
     * 获取分类和标签列表
     * @return 获取分类和标签列表
     */
    HashMap<String, Object> getCategoryAndTag();

    /**
     * 保存博客
     * @param blogDto
     * @return
     */
    AjaxResponse saveBlog(BlogDto blogDto);

    /**
     * 获取博客文章列表
     * @return
     */
    AjaxResponse ListPageBlog();

    /**
     * 分页获取文章列表
     * @param blogPage 分页参数
     * @param queryInfo 查询条件
     * @return
     */
    AjaxResponse pageBlogList(Page<Blog> blogPage, QueryBlogDto queryInfo);
}
