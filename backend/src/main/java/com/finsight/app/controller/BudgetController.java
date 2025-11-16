package com.finsight.app.controller;

import com.finsight.app.model.Budget;
import com.finsight.app.model.User;
import com.finsight.app.service.BudgetService;
import com.finsight.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
@CrossOrigin
public class BudgetController {

    private final BudgetService budgetService;
    private final UserService userService;

    public BudgetController(BudgetService budgetService,
                            UserService userService) {
        this.budgetService = budgetService;
        this.userService = userService;
    }

    private User getUserOrThrow(Long userId) {
        return userService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping
    public ResponseEntity<List<Budget>> getBudgets(@RequestParam Long userId) {
        User user = getUserOrThrow(userId);
        return ResponseEntity.ok(budgetService.getBudgetsForUser(user));
    }

    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestParam Long userId,
                                               @RequestBody Budget budget) {
        User user = getUserOrThrow(userId);
        budget.setUser(user);
        return ResponseEntity.ok(budgetService.save(budget));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        budgetService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
