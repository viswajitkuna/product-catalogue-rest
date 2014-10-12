package com.sample.service;

import com.sample.service.dto.ProductDetails;

import java.util.List;

public interface ProductCatalogueService {

    List<ProductDetails> getAllProducts();

    ProductDetails getProduct(long id);

    ProductDetails purchaseProduct(long id, int quantity);

}
