package com.javaweb.jetty.fillter.listener.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Date;

public class SessionReportListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if(event.getName().equals("User")){
            System.out.println(event.getValue()+":Login:"+new Date());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if(event.getName().equals("User")){
            System.out.println(event.getValue()+":Logout:"+new Date());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
