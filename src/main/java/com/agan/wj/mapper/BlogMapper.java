package com.agan.wj.mapper;

import com.agan.wj.entity.Blog;
import com.agan.wj.model.dto.QueryBlogDto;
import com.agan.wj.model.vo.BlogVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    /**
     * 根据条件分页显示文章列表
     * @param page
     * @param queryBlogDto
     * @return
     */
    IPage<BlogVo> pageBlogVo(Page<Blog> page, @Param("entity") QueryBlogDto queryBlogDto);
}
