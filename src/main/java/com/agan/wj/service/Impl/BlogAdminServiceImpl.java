package com.agan.wj.service.Impl;

import com.agan.wj.base.AjaxResponse;
import com.agan.wj.entity.Blog;
import com.agan.wj.entity.BlogTag;
import com.agan.wj.entity.Category;
import com.agan.wj.entity.Tag;
import com.agan.wj.mapper.BlogMapper;
import com.agan.wj.model.dto.BlogDto;
import com.agan.wj.model.dto.QueryBlogDto;
import com.agan.wj.service.*;
import com.agan.wj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@RequiredArgsConstructor
@Service
public class BlogAdminServiceImpl implements BlogAdminService {

    private final CategoryService categoryService;

    private final TagService tagService;

    private final BlogService blogService;

    private final BlogTagService blogTagService;

    private final BlogMapper blogMapper;

    /**
     * 获取分类和标签列表
     * @return 获取分类和标签列表
     */
    @Override
    public HashMap<String, Object> getCategoryAndTag() {
        List<Category> categories = categoryService.list();
        List<Tag> tags = tagService.list();

        // 转换为 uni-app DataCom 数据格式
//        List<DataComDto> categoryList = categories.stream().map((Category) ->
//                new DataComDto(Category.getId(), Category.getCategoryName())).collect(Collectors.toList());
//        List<DataComDto> tagList = tags.stream().map((Tag) ->
//                new DataComDto(Tag.getId(), Tag.getTagName())).collect(Collectors.toList());

        HashMap<String, Object> map = new HashMap<>(4);
        map.put("categories",categories);
        map.put("tags",tags);
        return map;
    }

    /**
     * 保存博客
     * @param blogDto
     * @return
     */
    @Override
    public AjaxResponse saveBlog(BlogDto blogDto) {
        Blog blog = new Blog();

        // 处理分类
        Object cate = blogDto.getCate();
        if (null == cate) {
            return AjaxResponse.error("分类不能为空");
        }
        if (cate instanceof Integer) {
           blog.setCategoryId((Integer)cate);
        }

        // 添加新分类
        if (cate instanceof String) {
            AjaxResponse ajaxResponse = categoryService.saveCategory(new Category(null,(String) cate));
            if (ajaxResponse.getCode() != 200) {
                return ajaxResponse;
            }
            blog.setCategoryId((Integer) ajaxResponse.getData());
        }

        // 处理标签
        List<Object> tagList = blogDto.getTagList();
        ArrayList<Tag> tags = new ArrayList<>();
        for (Object t : tagList) {
            if (t instanceof Integer) {
                tags.add(tagService.getById((Integer) t));
                // 添加新标签
            } else if (t instanceof String) {
                Tag tag = new Tag();
                tag.setTagName((String) t);
                AjaxResponse ajaxResponse = tagService.saveTag(tag);
                if (ajaxResponse.getCode() != 200) {
                    return ajaxResponse;
                }
                tag.setId((Integer) ajaxResponse.getData());
                tags.add(tag);

            }
        }

        Date date = new Date();

        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setFirstPicture(blogDto.getFirstPicture());
        blog.setUpdateTime(date);
        blog.setCreateTime(date);

        blogService.save(blog);

        // 关联博客和标签
        for (Tag tag : tags) {
            blogTagService.save(new BlogTag(blog.getId(), tag.getId()));
        }
        return AjaxResponse.success();
    }

    /**
     * 获取博客文章列表
     * @return
     */
    @Override
    public AjaxResponse ListPageBlog() {
        LambdaQueryWrapper<Blog> qw = new LambdaQueryWrapper<>();
        Page<Blog> blogPage = new Page<>();
        return AjaxResponse.success(PageUtil.toPageList(blogService.page(blogPage, qw)));
    }

    /**
     * 分页获取文章列表
     * @param blogPage  分页参数
     * @param queryInfo 查询条件
     * @return
     */
    @Override
    public AjaxResponse pageBlogList(Page<Blog> blogPage, QueryBlogDto queryInfo) {
        Map<String, Object> map = PageUtil.toPageList(blogMapper.pageBlogVo(blogPage, queryInfo));
        map.put("categoryList",categoryService.list());
        return AjaxResponse.success(map);
    }


}


