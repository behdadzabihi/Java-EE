package com.javaweb.jetty.fillter.listener.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener {
    private final static String OnlineUsers = "OnlineUsers";
    public void sessionCreated(HttpSessionEvent se) {
        Integer counter = (Integer) se.getSession().getServletContext().getAttribute(OnlineUsers);
        if(counter==null){
            counter=1;
        }else{
            counter++;
        }
        se.getSession().getServletContext().setAttribute(OnlineUsers, counter);

    }

    public void sessionDestroyed(HttpSessionEvent se) {
        Integer counter = (Integer) se.getSession().getServletContext().getAttribute(OnlineUsers);
        counter--;
        se.getSession().getServletContext().setAttribute(OnlineUsers, counter);
    }
}
