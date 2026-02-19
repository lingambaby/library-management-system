package com.lingambaby.library.service.impl;

import com.lingambaby.library.entity.Book;
import com.lingambaby.library.repository.BookRepository;
import com.lingambaby.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void removeBook(String isbn) {
        bookRepository.delete(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}