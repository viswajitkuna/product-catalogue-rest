package com.sample.dao.impl;

import com.sample.dao.ProductDao;
import com.sample.dao.domain.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext(unitName = "productCatalogue")
    private EntityManager entityManager;

    /**
     * Sets new entityManager.
     *
     * @param entityManager New value of entityManager.
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> getAllProducts() {
        Query query = entityManager.createQuery("FROM Product");
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product getProduct(long id) {
        return getProductDetails(id);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * Retrieves the details of the selected product.
     *
     * @param id Id of the selected product.
     * @return (link com.sample.dao.domain.Product} corresponding to the selected id.
     */
    private Product getProductDetails(long id) {
        Query query = entityManager.createQuery("FROM Product where id = :id");
        query.setParameter("id", id);
        return (Product) query.getSingleResult();
    }
}
