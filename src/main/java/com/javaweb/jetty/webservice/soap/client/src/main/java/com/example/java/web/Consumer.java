package com.example.java.web;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Consumer {
    public static void main(String[] args) throws MalformedURLException {
        QName SERVICE_NAME = new QName("http://session10.web.java.nikamooz.com/", "paymentService");
        String WSDL_LOCATION = "http://localhost:9091/paymentService?wsdl";

        URL wsdlURL = new URL(WSDL_LOCATION);
        Service service = Service.create(wsdlURL, SERVICE_NAME);
        PaymentService port = service.getPort(PaymentService.class);
        Payment payment = new Payment();
        payment.setAccountId("38723498723");
        payment.setAmount(10000000L);
        boolean result = port.deposit(payment);
    }
}
