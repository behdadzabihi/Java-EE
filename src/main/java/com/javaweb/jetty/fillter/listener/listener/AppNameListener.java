package com.javaweb.jetty.fillter.listener.listener;

import com.nikamooz.javaweb.session5.utility.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppNameListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("appName", Utils.getProperty("appName"));
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
