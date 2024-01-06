package com.javaweb.jetty.fillter.listener.utility;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Utils {

    private static Properties properties;

    private static Properties getProperties(){
        if(properties==null) {
            properties = new Properties();
            try {
                properties.load(Utils.class.getResourceAsStream("/application.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static String getProperty(String property){
        return getProperties().getProperty(property);
    }

    public static void logBody(HttpServletRequest request){
        Enumeration<String> headerNames = request.getParameterNames();
        System.err.println("<<<<<<<----- REQUEST BODY ------>>>>>>>");
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.err.println(name+":"+value);
        }
        System.err.println("--------------------------------------");

    }
    public static void logHeaders(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        System.err.println("<<<<<<<----- HEADER ------>>>>>>>");
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.err.println(name+":"+value);
        }
        System.err.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>");
    }

}
