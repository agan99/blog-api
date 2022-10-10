package com.agan.wj.service.Impl;

import com.agan.wj.entity.Blog;
import com.agan.wj.mapper.BlogMapper;
import com.agan.wj.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {


}
