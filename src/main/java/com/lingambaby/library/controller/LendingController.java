package com.lingambaby.library.controller;

import com.lingambaby.library.service.LendingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lending")
public class LendingController {

    private final LendingService lendingService;

    public LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @PostMapping("/checkout")
    public void checkout(@RequestParam String isbn,
                         @RequestParam String patronId) {
        lendingService.checkoutBook(isbn, patronId);
    }

    @PostMapping("/return")
    public void returnBook(@RequestParam String isbn,
                           @RequestParam String patronId) {
        lendingService.returnBook(isbn, patronId);
    }
}
