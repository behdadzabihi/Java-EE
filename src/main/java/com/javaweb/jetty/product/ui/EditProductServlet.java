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

@WebServlet(name = "EditProductServlet",urlPatterns = {"/editProduct"})
public class EditProductServlet extends HttpServlet {
    ProductDao productDao=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Long idValue = Long.parseLong(id);
        Product product = productDao.findOne(idValue);
        req.setAttribute("product", product);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/edit.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("Submit")!=null) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String factory = req.getParameter("factory");
            String model = req.getParameter("model");
            Product product = new Product(Long.parseLong(id), name, model, factory);
            productDao.update(product);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/viewProduct");
        rd.forward(req, resp);
    }
    }

