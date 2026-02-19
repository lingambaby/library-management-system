package com.lingambaby.library.repository;

import com.lingambaby.library.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryBookRepository implements BookRepository {

    private final Map<String, Book> books = new HashMap<>();

    @Override
    public void save(Book book) {
        books.put(book.getIsbn(), book);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public void delete(String isbn) {
        books.remove(isbn);
    }
}

