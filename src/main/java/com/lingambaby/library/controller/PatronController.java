package com.lingambaby.library.controller;

import com.lingambaby.library.entity.Patron;
import com.lingambaby.library.service.PatronService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrons")
public class PatronController {

    private final PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @PostMapping
    public void addPatron(@RequestBody Patron patron) {
        patronService.addPatron(patron);
    }

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public Patron getPatron(@PathVariable String id) {
        return patronService.getPatronById(id);
    }
}

