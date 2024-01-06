package com.javaweb.jetty.jsf;

import javax.faces.bean.ManagedBean;
@ManagedBean(name = "helloWorldBean")
public class HelloWorldBean {
    String message = "Hello World!";
    public String getMessage() {
        return message;
    }
}