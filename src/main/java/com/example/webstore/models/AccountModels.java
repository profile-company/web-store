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

    @Column(name = "enabled")
    private boolean enabled;

    public AccountModels() {

    }

    public AccountModels(String email, String password, String dateCreate, boolean enabled) {
        this.email = email;
        this.password = password;
        this.dateCreate = dateCreate;
        this.enabled = enabled;
    }

    public AccountModels(String email, String password, String dateCreate) {
        this.email = email;
        this.password = password;
        this.dateCreate = dateCreate;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "AccountModels{" + "email='" + email + '\'' + ", password='" + password + '\'' + ", dateCreate='" + dateCreate + '\'' + ", enabled=" + enabled + '}';
    }
}
