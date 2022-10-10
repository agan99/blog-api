package com.agan.wj.service.Impl;

import com.agan.wj.base.AjaxResponse;
import com.agan.wj.mapper.CategoryMapper;

import com.agan.wj.entity.Category;
import com.agan.wj.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    /**
     * 根据分类名查询
     * @param cate
     * @return
     */
    @Override
    public Category getByCategoryName(String cate) {
        LambdaQueryWrapper<Category> qw = new LambdaQueryWrapper<>();
        qw.eq(Category::getCategoryName, cate);
        return getOne(qw);
    }

    /**
     * 保存新分类
     * @param cate
     * @return id
     */
    @Override
    public AjaxResponse saveCategory(Category cate) {
        Category category = getByCategoryName(cate.getCategoryName());
        if (null != category) {
            return AjaxResponse.error("不可添加已存在的分类");
        }
        save(cate);
        return AjaxResponse.success(cate.getId());
    }
}
