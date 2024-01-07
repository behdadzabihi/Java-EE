package com.example.java.web;

import javax.jws.WebService;

@WebService(endpointInterface = "com.nikamooz.java.web.session10.PaymentService", serviceName = "paymentService")
public class PaymentServiceImpl implements PaymentService {

    DatabaseLogger logger;

    public boolean deposit(Payment payment) {
        logger.log(payment);
        System.out.println("Calling deposit: "+payment.getAccountId());
        return true;
    }

    public boolean withdraw(Payment payment) {
        logger.log(payment);
        System.out.println("Calling withdraw: "+payment);
        return true;
    }

    public void setLogger(DatabaseLogger logger) {
        this.logger = logger;
    }
}
