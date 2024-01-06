package com.javaweb.jetty.fillter.listener.listener;

import com.nikamooz.javaweb.session5.utility.Utils;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class LogRequestListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre) {
        Utils.logBody((HttpServletRequest) sre.getServletRequest());
        Utils.logHeaders((HttpServletRequest) sre.getServletRequest());
    }

    public void requestDestroyed(ServletRequestEvent sre) {
    }
}
