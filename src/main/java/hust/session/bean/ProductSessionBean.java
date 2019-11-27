package main.java.hust.session.bean;

import main.java.hust.entity.ProductEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductSessionBean extends BaseSessionBean<ProductEntity> {

    @PersistenceContext(unitName = "eMarketPU")
    private EntityManager entityManager;

    public ProductSessionBean(EntityManager entityManager) {
        super(ProductEntity.class);
        this.entityManager = entityManager;
    }

    public ProductSessionBean() {
        super(ProductEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
