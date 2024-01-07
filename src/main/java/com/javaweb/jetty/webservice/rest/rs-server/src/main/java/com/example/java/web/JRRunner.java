package com.example.java.web;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import java.util.ArrayList;
import java.util.List;

public class JRRunner {
    public static void main(String[] args) {
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        //for process json
        factory.setProvider(new JacksonJsonProvider());
        List resources = new ArrayList();
        resources.add(BookResource.class);
        resources.add(Book.class);
        factory.setResourceClasses(resources);
        factory.setAddress(
                "http://localhost:9003/");
        factory.create();
    }
}
