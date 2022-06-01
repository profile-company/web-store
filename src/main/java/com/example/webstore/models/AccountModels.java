package com.example.webstore.models;

import com.example.webstore.annotations.EmailValidation;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "account")
public class AccountModels {
    
    @Id
    @EmailValidation
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @Nullable
    @Column(name = "datetime")
    private String dateCreate;

    @Nullable
    @Column(name = "enabled")
    private boolean enabled;

    public AccountModels() {

    }

    public AccountModels(@NotNull String email, @NotNull String password,
            @Nullable String dateCreate, @Nullable boolean enabled) {
        this.email = email;
        this.password = password;
        this.dateCreate = dateCreate;
        this.enabled = enabled;
    }

    public AccountModels(@NotNull String email, @NotNull String password,
            @Nullable String dateCreate) {
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
