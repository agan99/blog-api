package com.agan.wj.service;

import com.agan.wj.base.AjaxResponse;
import com.agan.wj.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

public interface TagService extends IService<Tag> {

    /**
     * 根据标签名查询
     * @param name
     * @return
     */
    Tag getByTagName(String name);

    /**
     * 保存 tag
     * @param tag
     * @return
     */
    AjaxResponse saveTag(Tag tag);
}
