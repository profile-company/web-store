package com.example.webstore.models;

<<<<<<< HEAD
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.time.OffsetDateTime;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
>>>>>>> 90f8a670535fd20720da35a0b65ef9f8c7952b1f

@Entity
@Table(name = "customer")
public class CustomerModels {
<<<<<<< HEAD

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
=======
    @Id
>>>>>>> 90f8a670535fd20720da35a0b65ef9f8c7952b1f
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "dateborn")
<<<<<<< HEAD
    private OffsetDateTime dateBorn;
=======
    private String dateborn;
>>>>>>> 90f8a670535fd20720da35a0b65ef9f8c7952b1f

    @Column(name = "sex")
    private String sex;

    @Column(name = "account_email")
    private String accountEmail;

<<<<<<< HEAD
=======
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

>>>>>>> 90f8a670535fd20720da35a0b65ef9f8c7952b1f
    public String getFirstname() {
        return firstname;
    }

<<<<<<< HEAD
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

=======
>>>>>>> 90f8a670535fd20720da35a0b65ef9f8c7952b1f
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

<<<<<<< HEAD
    public OffsetDateTime getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(OffsetDateTime dateBorn) {
        this.dateBorn = dateBorn;
=======
    public String getDateborn() {
        return dateborn;
    }

    public void setDateborn(String dateborn) {
        this.dateborn = dateborn;
>>>>>>> 90f8a670535fd20720da35a0b65ef9f8c7952b1f
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
<<<<<<< HEAD
        return "CustomerModels{" + "id=" + id +
                ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' +
                ", dateBorn=" + dateBorn + ", sex='" + sex + '\'' + ", accountEmail='" + accountEmail + '\'' + '}';
=======
        return "CustomerModels{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateborn='" + dateborn + '\'' +
                ", sex='" + sex + '\'' +
                ", accountEmail='" + accountEmail + '\'' +
                '}';
>>>>>>> 90f8a670535fd20720da35a0b65ef9f8c7952b1f
    }
}
