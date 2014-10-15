package com.sample.rest;

import com.sample.service.dto.ProductDetails;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/*
 * Contains the REST end points corresponding to the product catalogue management.
 */
@Path("/products")
public interface ProductRest {

    /**
     * REST end point to retrieve all the available products.
     *
     * @return list of {@link com.sample.service.dto.ProductDetails}
     */
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_XML})
    List<ProductDetails> getAllProducts();


    /**
     * REST end point to retrieve the selected product
     *
     * @param id Id of the product
     * @return {@link com.sample.service.dto.ProductDetails} corresponding to the id being passed
     */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML})
    ProductDetails getProduct(@PathParam("id") long id);

    /**
     * REST end point to update the quantity of the current product that has been purchased and returns the updated
     * product details
     *
     * @param id Id of the product
     * @param quantity Quantity of the current product that has been purchased
     * @return {@link com.sample.service.dto.ProductDetails} corresponding to the id being passed
     */
    @POST
    @Path("{id}/{quantity}")
    @Produces({MediaType.APPLICATION_XML})
    ProductDetails purchaseProduct(@PathParam("id") long id, @PathParam("quantity") int quantity);
}
