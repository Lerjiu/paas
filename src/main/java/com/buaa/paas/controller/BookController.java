package com.buaa.paas.controller;

import com.buaa.paas.controller.response.DataResponse;
import com.buaa.paas.domain.Book;
import com.buaa.paas.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/book")
@ResponseBody
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/getAll")
    public DataResponse getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return DataResponse.success(books);
    }

    @RequestMapping("/get")
    public DataResponse getBook(int id) {
        Book book = bookService.getBook(id);
        return DataResponse.success(book);
    }
}
