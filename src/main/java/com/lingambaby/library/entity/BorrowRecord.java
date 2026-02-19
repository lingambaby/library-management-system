package com.lingambaby.library.entity;

import java.time.LocalDate;

public class BorrowRecord {

    private String isbn;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecord(String isbn, LocalDate borrowDate) {
        this.isbn = isbn;
        this.borrowDate = borrowDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void markReturned(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}

