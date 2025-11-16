package com.finsight.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    public enum Type {
        INCOME, EXPENSE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;

    @NotNull
    private String category;

    private String description;

    @NotNull
    private LocalDate date;

    public Transaction() {}

    public Transaction(User user, BigDecimal amount, Type type,
                       String category, String description, LocalDate date) {
        this.user = user;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public Long getId() { return id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public BigDecimal getAmount() { return amount; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }
}
