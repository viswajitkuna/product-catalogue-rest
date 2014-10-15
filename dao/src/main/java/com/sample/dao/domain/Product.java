package com.sample.dao.domain;

import javax.persistence.*;
import java.io.Serializable;

/*
 * Domain object for a product
 */

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String description;

    private int quantity;

    private double price;

    /*
     * Gets the quantity of the {@code} Product
     *
     * @return quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /*
     * Sets quantity of the {@code} Product
     *
     * @param quantity Quantity of the product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /*
     * Gets the price of the {@code} Product
     *
     * @return Price of the product
     */
    public double getPrice() {
        return price;
    }

    /*
     * Sets price of the {@code} Product
     *
     * @param price Price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /*
     * Gets the id of the {@code} Product
     *
     * @return id of the product
     */
    public long getId() {
        return id;
    }

    /*
     * Sets id of the {@code} Product
     *
     * @param id Id of the product
     */
    public void setId(long id) {
        this.id = id;
    }

    /*
     * Gets the name of the {@code} Product
     *
     * @return name of the product
     */
    public String getName() {
        return name;
    }

    /*
     * Sets name of the {@code} Product
     *
     * @param name Name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Gets the description of the {@code} Product
     *
     * @return description of the product
     */
    public String getDescription() {
        return description;
    }

    /*
     * Sets description of the {@code} Product
     *
     * @param description Description of the product
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {}

    public Product(long id, String name, String description, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != product.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
