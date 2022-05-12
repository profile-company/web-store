package com.example.webstore.models;

import javax.persistence.*;

@Entity
public class VerifyCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code", length = 64)
    private String code;

    @OneToOne(targetEntity = AccountModels.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name="email")
    private AccountModels accountModels;

    public VerifyCode() {}

    public VerifyCode(Long id, String code, AccountModels accountModels) {
        this.id = id;
        this.code = code;
        this.accountModels = accountModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AccountModels getAccountModels() {
        return accountModels;
    }

    public void setAccountModels(AccountModels accountModels) {
        this.accountModels = accountModels;
    }
}
