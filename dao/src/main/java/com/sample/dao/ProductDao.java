package com.sample.dao;

import com.sample.dao.domain.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();

    Product getProduct(long id);

    Product purchaseProduct(long id, int quantity);

}