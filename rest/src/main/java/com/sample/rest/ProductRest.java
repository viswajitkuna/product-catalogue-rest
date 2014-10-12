package com.sample.rest;

import com.sample.service.dto.ProductDetails;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
public interface ProductRest {

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_XML})
    List<ProductDetails> getAllProducts();

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML})
    ProductDetails getProduct(@PathParam("id") long id);

    @PUT
    @Path("{id}/{quantity}")
    @Produces({MediaType.APPLICATION_XML})
    ProductDetails purchaseProduct(@PathParam("id") long id, @PathParam("quantity") int quantity);

}
