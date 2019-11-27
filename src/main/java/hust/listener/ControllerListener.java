package main.java.hust.listener;

import main.java.hust.entity.ProductEntity;
import main.java.hust.session.bean.ProductSessionBean;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class ControllerListener implements ServletContextListener {
    @EJB
    ProductSessionBean productSessionBean;

    private ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        List<ProductEntity> products = productSessionBean.findAll();
        ProductEntity currentProduct = products.get((int) (Math.random() * products.size()));
        context.setAttribute("currentProduct", currentProduct);
        context.setAttribute("newProducts", productSessionBean.findAll());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }

}
