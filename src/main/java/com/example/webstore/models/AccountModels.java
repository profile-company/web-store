package com.example.webstore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountModels {
    
    @Id
    @Column(name="email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "datetime")
    private String dateCreate;

    public AccountModels(){}
    public AccountModels( String email, String password, String Date) {

    }

    public String getDateCreate(){
        return this.dateCreate;
    }
    public void setDateCreate(String date) {
        this.dateCreate = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
