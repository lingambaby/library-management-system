package com.lingambaby.library.repository;

import com.lingambaby.library.entity.Patron;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryPatronRepository implements PatronRepository {

    private final Map<String, Patron> patrons = new HashMap<>();

    @Override
    public void save(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    @Override
    public Optional<Patron> findById(String id) {
        return Optional.ofNullable(patrons.get(id));
    }

    @Override
    public List<Patron> findAll() {
        return new ArrayList<>(patrons.values());
    }
}

