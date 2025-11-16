package com.finsight.app.service;

import com.finsight.app.model.Budget;
import com.finsight.app.model.User;
import com.finsight.app.repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> getBudgetsForUser(User user) {
        return budgetRepository.findByUser(user);
    }

    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    public void delete(Long id) {
        budgetRepository.deleteById(id);
    }

    public Optional<Budget> findByUserAndCategoryAndMonthYear(User user, String category, String monthYear) {
        return budgetRepository.findByUserAndCategoryAndMonthYear(user, category, monthYear);
    }
}
