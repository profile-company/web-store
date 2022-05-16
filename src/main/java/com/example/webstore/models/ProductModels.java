package com.example.webstore.models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductModels {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "promotion")
    private int promotion;

    @Column(name = "type")
    private String type;

    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "price")
    private String price;

    @Column(name = "link_img")
    private String link;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "category_id")
    private int category_id;

    public ProductModels(int id, String name, int promotion, String type, int brandId, String price, String link,
                         String size, String quantity, int category_id) {
        this.id = id;
        this.name = name;
        this.promotion = promotion;
        this.type = type;
        this.brandId = brandId;
        this.price = price;
        this.link = link;
        this.size = size;
        this.quantity = quantity;
        this.category_id = category_id;
    }

    public ProductModels() {
    }

    public ProductModels(String name, int promotion, String type, int brandId, String price, String link, String size
            , String quantity, int category_id) {
        this.name = name;
        this.promotion = promotion;
        this.type = type;
        this.brandId = brandId;
        this.price = price;
        this.link = link;
        this.size = size;
        this.quantity = quantity;
        this.category_id = category_id;
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

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "ProductModels{" + "name='" + name + '\'' + ", type='" + type + '\'' + ", price='" + price + '\'' + "," +
                " size='" + size + '\'' + ", quantity='" + quantity + '\'' + '}';
    }
}
