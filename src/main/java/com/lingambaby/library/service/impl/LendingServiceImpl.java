package com.lingambaby.library.service.impl;

import com.lingambaby.library.entity.Book;
import com.lingambaby.library.entity.Patron;
import com.lingambaby.library.repository.BookRepository;
import com.lingambaby.library.repository.PatronRepository;
import com.lingambaby.library.service.LendingService;
import org.springframework.stereotype.Service;

@Service
public class LendingServiceImpl implements LendingService {

    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    public LendingServiceImpl(BookRepository bookRepository,
                              PatronRepository patronRepository) {
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    @Override
    public void checkoutBook(String isbn, String patronId) {

        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new RuntimeException("Patron not found"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is already borrowed");
        }

        book.setAvailable(false);
        patron.borrowBook(isbn);

        bookRepository.save(book);
        patronRepository.save(patron);
    }

    @Override
    public void returnBook(String isbn, String patronId) {

        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new RuntimeException("Patron not found"));

        book.setAvailable(true);
        patron.returnBook(isbn);

        bookRepository.save(book);
        patronRepository.save(patron);
    }
}

