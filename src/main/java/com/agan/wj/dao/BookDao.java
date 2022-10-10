package com.agan.wj.dao;

import com.agan.wj.pojo.Book;
import com.agan.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory(Category category);
    List<Book> findALLByTitleLikeOrAuthorLike(String title,String author);

    List<Book> findAllByTitleLikeOrAuthorLike(String s, String s1);
}
