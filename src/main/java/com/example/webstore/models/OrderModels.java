package com.example.webstore.models;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class OrderModels {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private int idOrder;

    @Column(name = "address")
    private String address;

    @Column(name = "phonenumber")
    private String phone;

    @Column(name = "datetime_order")
    private String dateTimeOrder;

    @Column(name = "account_email")
    private String email;

    public OrderModels(int idOrder, String address, String phone, String dateTimeOrder, String email) {
        this.idOrder = idOrder;
        this.address = address;
        this.phone = phone;
        this.dateTimeOrder = dateTimeOrder;
        this.email = email;
    }

    public OrderModels(String address, String phone, String dateTimeOrder, String email) {
        this.address = address;
        this.phone = phone;
        this.dateTimeOrder = dateTimeOrder;
        this.email = email;
    }

    public OrderModels() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(String dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrderModels{" + "address='" + address + '\'' + ", phone='" + phone + '\'' + ", dateTimeOrder='" + dateTimeOrder + '\'' + ", email='" + email + '\'' + '}';
    }
}
