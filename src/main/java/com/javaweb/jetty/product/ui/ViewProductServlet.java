package com.javaweb.jetty.product.ui;

import com.javaweb.jetty.product.dao.ProductDao;
import com.javaweb.jetty.product.domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="ViewProductServlet",urlPatterns = {"/viewProduct"})
public class ViewProductServlet extends HttpServlet {

    ProductDao productDao=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products=productDao.selectAll();
        req.setAttribute("products",products);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/view.jsp");
        rd.forward(req, resp);
    }
}
