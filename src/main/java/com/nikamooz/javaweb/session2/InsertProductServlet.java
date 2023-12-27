package com.nikamooz.javaweb.session2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "IPS", urlPatterns = {"/insertProduct"})
public class InsertProductServlet extends HttpServlet {

    Connection cn;
    public void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://192.168.1.41:3306/javaweb", "postgres", "123456");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    public void destroy() {
        try {
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            String name = req.getParameter("name");
            String model = req.getParameter("model");
            String factory = req.getParameter("factory");
            PreparedStatement ps = cn.prepareStatement("insert into product_tbl (name, model, factory) values (?, ? , ?)");
            ps.setString(1, name);
            ps.setString(2, model);
            ps.setString(3, factory);
            ps.executeUpdate();
            ps.close();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new ServletException(ex);
        }

    }
}
