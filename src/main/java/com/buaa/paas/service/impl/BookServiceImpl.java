package com.buaa.paas.service.impl;

import com.example.springboottest.dao.BookDao;
import com.example.springboottest.domain.Book;
import com.example.springboottest.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBook(int id) {
        return bookDao.getBook(id);
    }
}
