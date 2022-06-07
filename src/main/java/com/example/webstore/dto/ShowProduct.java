package com.example.webstore.dto;

import com.example.webstore.services.Product;

/**
 * The ShowProduct class provides objects to show at home page.
 * @author Nguyen Thuan
 * @version 1.00 07 June 2022
 *
 * Modification Logs:
 *      DATE                AUTHOR          DESCRIPTION
 * ------------------------------------------------------------
 */
public class ShowProduct implements Product {

    private int id;
    private String name;
    private String img;
    private String price;

    @Override
    public void doSomething() {
    }

    public ShowProduct(int id, String name, String img,
            String price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public ShowProduct() {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShowProduct{" + "id=" + id + ", name='" + name + '\'' + ", img='" + img + '\'' + ", price='" + price + '\'' + '}';
    }
}
