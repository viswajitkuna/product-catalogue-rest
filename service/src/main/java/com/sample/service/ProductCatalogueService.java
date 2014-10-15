package com.sample.service;

import com.sample.service.dto.ProductDetails;

import java.util.List;

/*
 * Service definition of product catalogue management
 */
public interface ProductCatalogueService {

    /**
     * Returns all the products available
     *
     * @return list of {@link com.sample.service.dto.ProductDetails}
     */
    List<ProductDetails> getAllProducts();

    /**
     * Returns the selected product
     *
     * @param id Id of the product
     * @return {@link com.sample.service.dto.ProductDetails} corresponding to the id being passed
     */
    ProductDetails getProduct(long id);

    /**
     * This method is used to update the quantity of the current product that has been purchased and returns the updated
     * product details
     *
     * @param id Id of the product
     * @param quantity Quantity of the current product that has been purchased
     * @return {@link com.sample.service.dto.ProductDetails} corresponding to the id being passed
     */
    ProductDetails purchaseProduct(long id, int quantity);

}
