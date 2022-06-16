package com.example.libary.Service;

import com.example.libary.Model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();
    Book addBook(Book book);
    Book updateBook(Book book);
    Book findBookById(Long id);
    void deleteBook(Long id);
}
