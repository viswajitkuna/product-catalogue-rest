package com.sample.service.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class ProductDetails implements Serializable {

    private long id;

    private String name;

    private String description;

    private int quantity;

    private double price;

    public ProductDetails() {}

    public ProductDetails(long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public ProductDetails(long id, String name, String description, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return Value of description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new description.
     *
     * @param description New value of description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets quantity.
     *
     * @return Value of quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets new quantity.
     *
     * @param quantity New value of quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets price.
     *
     * @return Value of price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets new price.
     *
     * @param price New value of price.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
