package com.example.webstore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderitems")
public class OrderItemModels {

    @Id
    @Column(name = "order_id")
    private int idOrder;

    @Column(name = "product_id")
    private int idProduct;

    @Column(name = "size")
    private String sizeProduct;

    @Column(name = "quantity")
    private int quantity;

    public OrderItemModels(int idOrder, int idProduct, String size, int quantity) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.sizeProduct = size;
        this.quantity = quantity;
    }

    public OrderItemModels() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getSizeProduct() {
        return sizeProduct;
    }

    public void setSizeProduct(String sizeProduct) {
        this.sizeProduct = sizeProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItemModels{" + "id=" + idOrder + ", idProduct=" + idProduct + ", size='" + sizeProduct + '\'' + ", quantity" +
                "=" + quantity + '}';
    }
}
