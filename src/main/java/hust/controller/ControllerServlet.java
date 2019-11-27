package main.java.hust.controller;

import main.java.hust.entity.ProductEntity;
import main.java.hust.session.bean.ProductSessionBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/products"})
public class ControllerServlet extends HttpServlet {

    @EJB
    private ProductSessionBean productSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductEntity> products = productSessionBean.findAll();

        String indexParamerter = req.getParameter("index");
        int position;
        try {
            position = Integer.parseInt(indexParamerter);
        } catch (NumberFormatException e) {
            position = 0;
        }
        ProductEntity currentProduct = products.get(position);
        System.out.println(products.stream().map(ProductEntity::getName).collect(Collectors.toList()));
        req.setAttribute("newProducts", products);
        req.setAttribute("currentProduct", currentProduct);
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
