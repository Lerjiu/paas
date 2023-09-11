package com.buaa.paas.service;

import com.example.springboottest.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBook(int id);
}
