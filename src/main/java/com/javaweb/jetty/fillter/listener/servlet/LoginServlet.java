package com.javaweb.jetty.fillter.listener.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username!=null&&password!=null){
            if(username.equalsIgnoreCase("admin")&&
            password.equalsIgnoreCase("admin")){
                req.getSession(true).setAttribute("User", "admin");
                req.getRequestDispatcher("/WEB-INF/protected.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            }
        }else{
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }
}
