package com.sample.dao.impl;

import com.sample.dao.ProductDao;
import com.sample.dao.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext(unitName = "productCatalogue")
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> getAllProducts() {
        Query query = entityManager.createQuery("FROM Product");
        return query.getResultList();
    }

    @Override
    public Product getProduct(long id) {
        return getProductDetails(id);
    }

    @Override
    public Product purchaseProduct(long id, int quantity) {
        int updatedQuantity = 0;
        Product product = getProductDetails(id);
        updatedQuantity = product.getQuantity() - quantity;
        product.setQuantity(updatedQuantity);
        Query query = entityManager.createQuery("UPDATE Product set quantity = :quantity where id = :id");
        query.setParameter("quantity", updatedQuantity);
        query.setParameter("id", id);
        query.executeUpdate();
        return product;
    }

    private Product getProductDetails(long id) {
        Query query = entityManager.createQuery("FROM Product where id = :id");
        query.setParameter("id", id);
        return (Product) query.getSingleResult();
    }
}
