package com.sample.dao;

import com.sample.dao.domain.Product;

import java.util.List;

/*
 * Contains all the DB related operations corresponding to the product catalogue management
 */
public interface ProductDao {

    /**
     * Returns all the products available
     *
     * @return list of {@link com.sample.dao.domain.Product}
     */
    List<Product> getAllProducts();

    /**
     * Returns the selected product
     *
     * @param id Id of the product
     * @return {@link com.sample.dao.domain.Product} corresponding to the id being passed
     */
    Product getProduct(long id);

    /**
     * This method is used to update the quantity of the current product that has been purchased and returns the updated
     * product details
     *
     * @param id Id of the product
     * @param quantity Quantity of the current product that has been purchased
     * @return {@link com.sample.dao.domain.Product} corresponding to the id being passed
     */
    Product purchaseProduct(long id, int quantity);

}