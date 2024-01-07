package com.example.java.web;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class CxfStyleClient {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(PaymentService.class);
        factory.setAddress("http://localhost:9091/paymentService");
        PaymentService client = (PaymentService) factory.create();
        Payment payment = new Payment();
        payment.setAccountId("38723498723");
        payment.setAmount(10000000L);
        boolean result = client.deposit(payment);
    }

}
