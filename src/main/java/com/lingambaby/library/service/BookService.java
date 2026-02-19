package com.lingambaby.library.service;

import com.lingambaby.library.entity.Book;
import java.util.List;

public interface BookService {

    void addBook(Book book);

    void removeBook(String isbn);

    List<Book> getAllBooks();

    Book getBookByIsbn(String isbn);

    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);

    void updateBook(Book book);
}



