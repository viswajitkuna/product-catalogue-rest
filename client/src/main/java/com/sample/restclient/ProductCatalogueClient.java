package com.sample.restclient;


import com.sample.service.dto.ProductDetails;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

/*
 * Client to invoke the REST end points defined in {@link com.sample.rest.ProductRest}
 */
public class ProductCatalogueClient {
    private static final String GET_ALL_PRODUCTS_REST_URI = "http://localhost:8080/product-catalogue-rest/services/products/all";
    private static final String GET_PRODUCT_REST_URI = "http://localhost:8080/product-catalogue-rest/services/products/1";
    private static final String PURCHASE_PRODUCT_REST_URI = "http://localhost:8080/product-catalogue-rest/services/products/1/2";

    /*
     * Starting point of execution. Invoked by JVM.
     */
    public static void main(String[] args) {
        //Get the list of available products
        System.out.println("Get All Products....!!!");
        invokeGetAllProducts();
        //Get the details of a selected product
        System.out.println("Get Product....!!!");
        invokeGetProduct();
        //Purchase a product and update its available quantity
        System.out.println("Purchase a Product....!!!");
        invokePurchaseProduct();
    }

    /*
     * Invokes the REST end point defined for retrieving the list of available products.
     */
    private static void invokeGetAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap> productDetailsList = restTemplate.getForObject(GET_ALL_PRODUCTS_REST_URI, List.class);
        for(LinkedHashMap productDetails : productDetailsList) {
            System.out.println("Product Id: " + productDetails.get("id")
                    + "Product Name: " + productDetails.get("name")
                    + "Product Description: " + productDetails.get("description")
                    + "Quantity: " + productDetails.get("quantity")
                    + "Price: " + productDetails.get("price"));
        }
    }

    /*
     * Invokes the REST end point defined for retrieving the details of the selected product
     */
    private static void invokeGetProduct() {
        RestTemplate restTemplate = new RestTemplate();
        ProductDetails productDetails = restTemplate.getForObject(GET_PRODUCT_REST_URI, ProductDetails.class);
        printProductDetails(productDetails);
    }

    /*
     * Invokes the REST end point defined for purchasing a product and update its available quantity.
     */
    private static void invokePurchaseProduct() {
        RestTemplate restTemplate = new RestTemplate();
        ProductDetails productDetails = restTemplate.getForObject(PURCHASE_PRODUCT_REST_URI, ProductDetails.class);
        printProductDetails(productDetails);
    }

    /*
     * Prints the details of the current product on the console.
     */
    private static void printProductDetails(ProductDetails productDetails) {
        System.out.println("Product Id: " + productDetails.getId()
                            + "Product Name: " + productDetails.getName()
                            + "Product Description: " + productDetails.getDescription()
                            + "Quantity: " + productDetails.getQuantity()
                            + "Price: " + productDetails.getPrice());
    }
}
