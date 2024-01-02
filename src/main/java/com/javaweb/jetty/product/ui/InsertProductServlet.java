package com.javaweb.jetty.product.ui;

import com.javaweb.jetty.product.dao.ProductDao;
import com.javaweb.jetty.product.domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertProductServlet", urlPatterns = {"/insertProduct"})
public class InsertProductServlet extends HttpServlet {

    ProductDao productDao=new ProductDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            String model = req.getParameter("model");
            String factory = req.getParameter("factory");
            Product product=new Product(name,model,factory);
            productDao.save(product);
            RequestDispatcher dispatcher=req.getRequestDispatcher("/viewProduct");
            dispatcher.forward(req,resp);
        }

    }

