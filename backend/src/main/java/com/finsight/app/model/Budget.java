package com.finsight.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private String category;

    @NotNull
    private BigDecimal monthlyLimit;

    @NotNull
    private String monthYear;

    public Budget() {}

    public Budget(User user, String category, BigDecimal monthlyLimit, String monthYear) {
        this.user = user;
        this.category = category;
        this.monthlyLimit = monthlyLimit;
        this.monthYear = monthYear;
    }

    public Long getId() { return id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public BigDecimal getMonthlyLimit() { return monthlyLimit; }

    public void setMonthlyLimit(BigDecimal monthlyLimit) { this.monthlyLimit = monthlyLimit; }

    public String getMonthYear() { return monthYear; }

    public void setMonthYear(String monthYear) { this.monthYear = monthYear; }
}
