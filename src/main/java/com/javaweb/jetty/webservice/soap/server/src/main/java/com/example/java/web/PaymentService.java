package com.example.java.web;

import javax.jws.WebService;

@WebService
public interface PaymentService {
    public boolean deposit(Payment payment);
    public boolean withdraw(Payment payment);
}
