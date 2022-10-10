package com.agan.wj.controller;

import com.agan.wj.base.AjaxResponse;
import com.agan.wj.entity.Book;
import com.agan.wj.service.BookService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/library")
public class bookController {

    private final BookService bookService;

    /**
     * 分页查询书籍数据
     * @param page
     * @return
     */
    @GetMapping("/pageList")
    public AjaxResponse list(Page<Book> page) {
        System.out.println(page.getSize());
        return AjaxResponse.success(bookService.listPage(page));
    }
}
