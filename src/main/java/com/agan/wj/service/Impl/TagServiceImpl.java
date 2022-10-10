package com.agan.wj.service.Impl;

import com.agan.wj.base.AjaxResponse;
import com.agan.wj.mapper.TagMapper;
import com.agan.wj.entity.Tag;
import com.agan.wj.service.TagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    /**
     * 根据标签名查询标签
     * @param name
     * @return
     */
    @Override
    public Tag getByTagName(String name) {
        LambdaQueryWrapper<Tag> qw = new LambdaQueryWrapper<>();
        qw.eq(Tag::getTagName,name);
        return getOne(qw);
    }

    /**
     * 保存 tag
     * @param tag
     * @return
     */
    @Override
    public AjaxResponse saveTag(Tag tag) {
        Tag tagName = getByTagName(tag.getTagName());
        if(null != tagName){
            return AjaxResponse.error("不可添加已存在标签");
        }
        save(tag);
        return AjaxResponse.success(tag.getId());
    }
}
