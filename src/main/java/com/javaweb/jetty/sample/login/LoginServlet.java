package com.javaweb.jetty.sample.login;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(smallIcon = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

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
        Integer counter = (Integer) application.getAttribute("login-counter");
        if(counter ==null){
            counter=0;
        }
        counter++;
        application.setAttribute("login-counter",counter);
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if("admin".equals(username) && "admin".equals(password)){
            HttpSession session=req.getSession(true);
            session.setAttribute("username",username);
            session.setAttribute("loin-time",new Date());
            resp.sendRedirect("/profile.jsp");
        }else{
            resp.sendRedirect("/login.jsp");
        }

    }
}
