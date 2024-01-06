package com.javaweb.jetty.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "welcomeBean")
public class WelcomeBean {

    String message = "Welcome To JSF Technology:)";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
