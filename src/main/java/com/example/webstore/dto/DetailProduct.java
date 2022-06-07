package com.example.webstore.dto;

import com.example.webstore.services.Product;

/**
 * The DetailProduct class provides objects to show at product page.
 * @author Nguyen Thuan
 * @version 1.00 07 June 2022
 *
 * Modification Logs:
 *      DATE                AUTHOR          DESCRIPTION
 * ------------------------------------------------------------
 */
public class DetailProduct implements Product {

    private int id;
    private String name;
    private String category;
    private String price;
    private String description;
    private String sizes;
    private String images;

    @Override
    public void doSomething() {

    }

    public DetailProduct(int id, String name, String category,
            String price, String description,
            String sizes, String images) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.sizes = sizes;
        this.images = images;
    }

    public DetailProduct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "DetailProduct{" + "id=" + id + ", name='" + name + '\'' + ", category='" + category + '\'' + ", price" +
                "='" + price + '\'' + ", description='" + description + '\'' + ", sizes='" + sizes + '\'' + ", images" +
                "='" + images + '\'' + '}';
    }
}
