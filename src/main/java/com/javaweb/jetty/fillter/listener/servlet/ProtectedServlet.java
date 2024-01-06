package com.javaweb.jetty.fillter.listener.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProtectedServlet", urlPatterns = "/protected")
public class ProtectedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession(true).getAttribute("User")!=null) {
            req.getRequestDispatcher("/WEB-INF/protected.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }
}
