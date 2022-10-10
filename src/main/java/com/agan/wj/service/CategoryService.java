package com.agan.wj.service;

import com.agan.wj.base.AjaxResponse;
import com.agan.wj.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CategoryService extends IService<Category> {

    /**
     * 根据分类名查询
     * @param cate
     * @return
     */
    Category getByCategoryName(String cate);

    /**
     * 保存分类
     * @param cate
     * @return id
     */
    AjaxResponse saveCategory(Category cate);
}
