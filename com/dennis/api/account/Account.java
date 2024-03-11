package com.dennis.api.account;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Account {
    private Long id;
    private String accountNumber;
    private String accountHolder;
    private Double balance;
    private LocalDate transactionDate;
    private String returnType;

    @Builder(builderMethodName = "builder")
    public Account(long id, String accountNumber, String accountHolder, double balance, LocalDate transactionDate, String returnType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionDate = transactionDate;
        this.returnType = returnType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}