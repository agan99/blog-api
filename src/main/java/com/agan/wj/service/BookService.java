package com.agan.wj.service;

import com.agan.wj.entity.Book;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface BookService extends IService<Book> {

    Map<String, Object> listPage(Page<Book> page);
}
