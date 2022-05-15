package com.example.webstore.models;

import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class CustomerModels {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "dateborn")
    private String dateBorn;

    @Column(name = "sex")
    private String sex;

    @Column(name = "account_email")
    private String accountEmail;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public CustomerModels() {

    }

    public CustomerModels(String firstname,
                          String lastname,
                          String dateBorn,
                          String sex,
                          String accountEmail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateBorn = dateBorn;
        this.sex = sex;
        this.accountEmail = accountEmail;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    @Override
    public String toString() {
        return "CustomerModels{" + "id=" + id +
                ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' +
                ", dateBorn=" + dateBorn + ", sex='" + sex + '\'' + ", accountEmail='" + accountEmail + '\'' + '}';

    }
}
