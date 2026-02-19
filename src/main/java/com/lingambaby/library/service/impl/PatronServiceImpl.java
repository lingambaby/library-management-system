package com.lingambaby.library.service.impl;

import com.lingambaby.library.entity.Patron;
import com.lingambaby.library.repository.PatronRepository;
import com.lingambaby.library.service.PatronService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronServiceImpl implements PatronService {

    private final PatronRepository patronRepository;

    public PatronServiceImpl(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    @Override
    public void addPatron(Patron patron) {
        patronRepository.save(patron);
    }

    @Override
    public Patron getPatronById(String id) {
        return patronRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patron not found"));
    }

    @Override
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }
}

