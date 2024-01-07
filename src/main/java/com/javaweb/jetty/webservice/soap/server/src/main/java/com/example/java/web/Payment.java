package com.example.java.web;

public class Payment {
    String accountId;
    Long amount;

    public Payment() {
    }

    public Payment(String accountId, Long amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "accountId='" + accountId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
