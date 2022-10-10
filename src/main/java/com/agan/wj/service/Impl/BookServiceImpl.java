package com.agan.wj.service.Impl;

import com.agan.wj.mapper.BookMapper;

import com.agan.wj.entity.Book;
import com.agan.wj.service.BookService;

import com.agan.wj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    private final BookMapper bookMapper;

    @Override
    public Map<String, Object> listPage(Page<Book> page) {
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<>();
        return PageUtil.toPageList(bookMapper.selectPage(page, qw));
    }
}
