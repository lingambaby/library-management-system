package com.lingambaby.library.repository;

import com.lingambaby.library.entity.Patron;

import java.util.List;
import java.util.Optional;

public interface PatronRepository {

    void save(Patron patron);

    Optional<Patron> findById(String id);

    List<Patron> findAll();
}

