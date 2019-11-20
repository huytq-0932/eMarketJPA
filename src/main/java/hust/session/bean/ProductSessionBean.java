package main.java.hust.session.bean;

import main.java.hust.entity.ProductEntity;

import javax.persistence.EntityManager;

public class ProductSessionBean extends BaseSessionBean<ProductEntity> {

    private EntityManager entityManager;

    public ProductSessionBean(EntityManager entityManager) {
        super(ProductEntity.class);
        this.entityManager = entityManager;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
