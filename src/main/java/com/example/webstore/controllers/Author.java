package com.example.webstore.controllers;

import com.example.webstore.repository.AccountRepository;

// import org.springframework.beans.factory.annotation.Autowired;

public class Author {

    private AccountRepository repo;
    private String password;
    private String email;

    public Author(String email, String password, AccountRepository repo) {
        this.email = email;
        this.password = password;
        this.repo = repo;
    }

    public Boolean isPassOfAccount() {
        String myPass = findPass();
        if (myPass !=  null) {
            if (myPass.equals(this.password)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlreadyEmail() {
        if (repo.existsEmail(this.email) != 0) {
            return false;
        }
        else { return true; }
    }

    private String findPass() {

        String tmp = repo.findPassword(this.email);
        if (tmp != null) {
            System.out.println(tmp);
            return tmp;
        }
        else {

            return null;
        }
    }
}
