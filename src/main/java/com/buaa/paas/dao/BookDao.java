package com.buaa.paas.dao;

import com.example.springboottest.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {
    @Select("select * from book")
    List<Book> getAllBooks();

    @Select("select * from book where id = #{id}")
    Book getBook(int id);
}
