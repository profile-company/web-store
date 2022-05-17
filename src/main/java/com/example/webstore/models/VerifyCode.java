package com.example.webstore.models;

import javax.persistence.*;

@Entity
@Table(name = "verifycode")
public class VerifyCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code", length = 64)
    private String code;

    @Column(name = "account_email")
    private String email;

    public VerifyCode() {}

    public VerifyCode(Integer id, String code, String email) {
        this.id = id;
        this.code = code;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "VerifyCode{" + "id=" + id + ", code='" + code + '\'' + ", email='" + email + '\'' + '}';
    }
}
