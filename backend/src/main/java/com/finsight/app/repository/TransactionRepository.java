package com.finsight.app.repository;

import com.finsight.app.model.Transaction;
import com.finsight.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);

    List<Transaction> findByUserAndDateBetween(User user, LocalDate start, LocalDate end);
}
