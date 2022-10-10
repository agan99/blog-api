package com.agan.wj.service.Impl;

import com.agan.wj.entity.BlogTag;
import com.agan.wj.mapper.BlogTagMapper;
import com.agan.wj.service.BlogTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements BlogTagService {
}
