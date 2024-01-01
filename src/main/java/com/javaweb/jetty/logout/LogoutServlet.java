package com.javaweb.jetty.logout;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "LogoutServlet",urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext application=req.getServletContext();
        Integer counter= (Integer) application.getAttribute("login-counter");
        if(counter != null){
            counter --;
            application.setAttribute("login-counter",counter);
        }
        HttpSession session=req.getSession(true);
        session.invalidate();
        resp.sendRedirect("/login.jsp");
    }
}
