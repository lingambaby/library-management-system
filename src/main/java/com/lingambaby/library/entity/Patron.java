package com.lingambaby.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Patron {

    private final String id;
    private String name;
    private String email;
    private List<String> borrowedBooks;

    public Patron(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(String isbn) {
        borrowedBooks.add(isbn);
    }

    public void returnBook(String isbn) {
        borrowedBooks.remove(isbn);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}