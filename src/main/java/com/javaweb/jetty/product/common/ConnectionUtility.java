package com.javaweb.jetty.product.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtility {

    public static Connection cn;

    public static Connection getConnection(){
        if(cn==null){
            try {
                Properties properties=new Properties();
                properties.load(ConnectionUtility.class.getResourceAsStream("/postgres.properties"));
                Class.forName(properties.getProperty("db.driver"));
                cn= DriverManager.getConnection(properties.getProperty("db.url"),
                properties.getProperty("db.username"),
                properties.getProperty("db.password"));
                cn.setAutoCommit(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cn;
    }
}
