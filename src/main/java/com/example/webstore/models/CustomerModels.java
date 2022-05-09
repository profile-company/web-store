package com.example.webstore.models;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "customer")
public class CustomerModels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "dateborn")
    private OffsetDateTime dateBorn;

    @Column(name = "sex")
    private String sex;

    @Column(name = "account_email")
    private String accountEmail;

    public String getFirstname() {
        return firstname;
    }

    public CustomerModels() {
        this.firstname = null;
        this.lastname = null;
        this.dateBorn = null;
        this.sex = null;
        this.accountEmail = null;
    }

    public CustomerModels(String firstname,
                          String lastname,
                          OffsetDateTime dateBorn,
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

    public OffsetDateTime getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(OffsetDateTime dateBorn) {
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
