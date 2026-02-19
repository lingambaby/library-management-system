package com.lingambaby.library.service;

import com.lingambaby.library.entity.Patron;
import java.util.List;

public interface PatronService {

    void addPatron(Patron patron);

    Patron getPatronById(String id);

    List<Patron> getAllPatrons();
}
