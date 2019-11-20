package main.java.hust.controller;

import main.java.hust.entity.ProductEntity;
import main.java.hust.session.bean.ProductSessionBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ControllerServlet", loadOnStartup = 1, urlPatterns = {"/products"})
public class ControllerServlet extends HttpServlet {

    private ProductSessionBean productSessionBean;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("eMarketPU");
        EntityManager entityManager = factory.createEntityManager();
        productSessionBean = new ProductSessionBean(entityManager);
    }

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
