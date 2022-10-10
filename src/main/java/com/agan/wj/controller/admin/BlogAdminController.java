package com.agan.wj.controller.admin;

import com.agan.wj.base.AjaxResponse;
import com.agan.wj.entity.Blog;
import com.agan.wj.model.dto.BlogDto;
import com.agan.wj.model.dto.QueryBlogDto;
import com.agan.wj.service.BlogAdminService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class BlogAdminController {

    private final BlogAdminService blogAdminService;

    /**
     * 获取分类和标签列表
     * @return 分类和标签列表
     */
    @GetMapping("/getCategoryAndTag")
    public AjaxResponse getCategoryAndTag(){
        return AjaxResponse.success(blogAdminService.getCategoryAndTag());
    }

    /**
     * 保存博客
     * @return 成功信息
     */
    @PostMapping("/saveBlog")
    public AjaxResponse saveBlog(@RequestBody BlogDto blogDto){
        return blogAdminService.saveBlog(blogDto);
    }

    /**
     * 获取博客文章列表
     * @return
     */
    @GetMapping("/pageBlog")
    public AjaxResponse pageBlogList(Page<Blog> blogPage, QueryBlogDto queryInfo){
        return blogAdminService.pageBlogList(blogPage, queryInfo);
    }
}
