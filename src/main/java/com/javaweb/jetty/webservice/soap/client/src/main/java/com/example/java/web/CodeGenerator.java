package com.example.java.web;

import org.apache.cxf.tools.wsdlto.WSDLToJava;

public class CodeGenerator {
    public static void main(String[] args) {
        WSDLToJava.main(new String[]{"-d", "src/main/java", "-wsdl", "http://localhost:9091/paymentService?wsdl"});

    }
}
