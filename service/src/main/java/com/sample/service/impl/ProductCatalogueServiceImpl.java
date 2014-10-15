package com.sample.service.impl;

import com.sample.dao.ProductDao;
import com.sample.dao.domain.Product;
import com.sample.service.ProductCatalogueService;
import com.sample.service.dto.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/*
 * Implementation of {@link com.sample.service.ProductCatalogueService}
 */
@Transactional
public class ProductCatalogueServiceImpl implements ProductCatalogueService {

    private ProductDao productDao;

    /**
     * Sets new productDao.
     *
     * @param productDao New value of productDao.
     */
    @Required
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductDetails> getAllProducts() {
        List<ProductDetails> productDetails = new ArrayList<ProductDetails>();
        List<Product> products = productDao.getAllProducts();
        for (Product product : products) {
            productDetails.add(new ProductDetails(product.getId(), product.getName(), product.getDescription(),
                    product.getQuantity(), product.getPrice()));
        }
        return productDetails;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetails getProduct(long id) {
        Product product = productDao.getProduct(id);
        if (product == null) {
            throw new EntityNotFoundException("No product exists with id: " + id);
        }
        return new ProductDetails(product.getId(), product.getName(), product.getDescription(), product.getQuantity(),
                product.getPrice());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetails purchaseProduct(long id, int quantity) {
        Product product = productDao.purchaseProduct(id, quantity);
        return new ProductDetails(product.getId(), product.getName(), product.getDescription(), product.getQuantity(),
                product.getPrice());
    }
}
