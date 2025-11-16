package com.finsight.app.repository;

import com.finsight.app.model.Budget;
import com.finsight.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    List<Budget> findByUser(User user);

    Optional<Budget> findByUserAndCategoryAndMonthYear(User user, String category, String monthYear);
}
