package com.finsight.app.service;

import com.finsight.app.model.Transaction;
import com.finsight.app.model.User;
import com.finsight.app.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllForUser(User user) {
        return transactionRepository.findByUser(user);
    }

    public List<Transaction> getForUserBetweenDates(User user, LocalDate start, LocalDate end) {
        return transactionRepository.findByUserAndDateBetween(user, start, end);
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }
}
