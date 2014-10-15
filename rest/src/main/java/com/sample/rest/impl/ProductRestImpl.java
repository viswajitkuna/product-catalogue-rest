package com.sample.rest.impl;

import com.sample.rest.ProductRest;
import com.sample.service.ProductCatalogueService;
import com.sample.service.dto.ProductDetails;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/*
 * Implementation of {@link com.sample.rest.ProductRest}
 */
public class ProductRestImpl implements ProductRest {

    private ProductCatalogueService productService;

    /**
     * Sets new productService.
     *
     * @param productService New value of productService.
     */
    @Required
    public void setProductService(ProductCatalogueService productService) {
        this.productService = productService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductDetails> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetails getProduct(long id) {
        return productService.getProduct(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetails purchaseProduct(long id, int quantity) {
        return productService.purchaseProduct(id, quantity);
    }
}
