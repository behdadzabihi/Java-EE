package com.javaweb.jetty.fillter.listener.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class UserAgentListener implements ServletRequestListener {

    final static String Mozilla = "Mozilla";
    final static String Chrome = "Chrome";
    final static String Explorer = "Explorer";
    final static String Others = "Others";
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        String userAgent = ((HttpServletRequest)sre.getServletRequest()).getHeader("User-Agent");
        ServletContext context = sre.getServletContext();
        String user = userAgent.toLowerCase();

        String browser = "Chrome";
        //===============Browser===========================
        if (user.contains("msie"))
        {
            String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser="IE";
        } else if (user.contains("safari") && user.contains("version"))
        {
            browser="Firefox";
        } else if ( user.contains("opr") || user.contains("opera"))
        {
            if(user.contains("opera"))
                browser="Opera";
        } else if (user.contains("chrome"))
        {
            browser="chrome";
        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
        {
            //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
            browser = "Netscape";

        } else if (user.contains("firefox"))
        {
            browser="Firefox";
        } else if(user.contains("rv"))
        {
            browser="IE";
        } else
        {
            browser = "UnKnown";
        }

        incrementCounter(browser, context);

//        if(browser.contains(Mozilla)){
//
//        }else if(browser.contains(Chrome)){
//            incrementCounter(Chrome, context);
//        }else if(browser.contains(Explorer)){
//            incrementCounter(Explorer, context);
//        }else{
//            incrementCounter(Others, context);
//        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    private void incrementCounter(String userAgent, ServletContext context){
        Integer counter = (Integer) context.getAttribute(userAgent);
        if(counter==null){
            counter=1;
        }else{
            counter++;
        }
        context.setAttribute(userAgent, counter);
    }
}
