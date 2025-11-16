package com.finsight.app.service;

import com.finsight.app.model.Transaction;
import com.finsight.app.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {

    private final TransactionService transactionService;

    public AnalyticsService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Map<String, Object> getSummary(User user) {
        List<Transaction> transactions = transactionService.getAllForUser(user);
        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalExpense = BigDecimal.ZERO;

        for (Transaction tx : transactions) {
            if (tx.getType() == Transaction.Type.INCOME) {
                totalIncome = totalIncome.add(tx.getAmount());
            } else {
                totalExpense = totalExpense.add(tx.getAmount());
            }
        }

        Map<String, Object> summary = new HashMap<>();
        summary.put("totalIncome", totalIncome);
        summary.put("totalExpense", totalExpense);
        summary.put("netSavings", totalIncome.subtract(totalExpense));
        return summary;
    }

    public Map<String, BigDecimal> getSpendingByCategory(User user) {
        List<Transaction> transactions = transactionService.getAllForUser(user);
        Map<String, BigDecimal> byCategory = new HashMap<>();
        for (Transaction tx : transactions) {
            if (tx.getType() == Transaction.Type.EXPENSE) {
                byCategory.merge(tx.getCategory(), tx.getAmount(), BigDecimal::add);
            }
        }
        return byCategory;
    }
}
