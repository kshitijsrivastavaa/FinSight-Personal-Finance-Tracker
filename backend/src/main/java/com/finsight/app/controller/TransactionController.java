package com.finsight.app.controller;

import com.finsight.app.model.Transaction;
import com.finsight.app.model.User;
import com.finsight.app.service.TransactionService;
import com.finsight.app.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService,
                                 UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    private User getUserOrThrow(Long userId) {
        return userService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactions(
            @RequestParam Long userId,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        User user = getUserOrThrow(userId);

        if (startDate != null && endDate != null) {
            return ResponseEntity.ok(
                    transactionService.getForUserBetweenDates(user, startDate, endDate)
            );
        }
        return ResponseEntity.ok(transactionService.getAllForUser(user));
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(
            @RequestParam Long userId,
            @RequestBody Transaction transaction) {

        User user = getUserOrThrow(userId);
        transaction.setUser(user);
        Transaction saved = transactionService.save(transaction);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
