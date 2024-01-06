package com.javaweb.jetty.fillter.listener.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ContextReportListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("Attribute Remoted: "+event.getName());
        System.out.println("Last Value: "+event.getServletContext().getAttribute(event.getName()));
        System.out.println("New Value:" + event.getValue());
    }
}
