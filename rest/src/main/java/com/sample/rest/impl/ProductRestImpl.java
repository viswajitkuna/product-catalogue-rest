package com.sample.rest.impl;

import com.sample.rest.ProductRest;
import com.sample.service.ProductCatalogueService;
import com.sample.service.dto.ProductDetails;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class ProductRestImpl implements ProductRest {

    private ProductCatalogueService productService;

    @Required
    public void setProductService(ProductCatalogueService productService) {
        this.productService = productService;
    }

    @Override
    public List<ProductDetails> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public ProductDetails getProduct(long id) {
        return productService.getProduct(id);
    }

    @Override
    public ProductDetails purchaseProduct(long id, int quantity) {
        return productService.purchaseProduct(id, quantity);
    }
}
