package com.example.java.web;

import javax.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
        PaymentServiceImpl service = new PaymentServiceImpl();
        Endpoint.publish("http://localhost:9091/paymentService", service);
    }
}
