package com.example.webstore.controllers;

import com.example.webstore.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import org.springframework.beans.factory.annotation.Autowired;

@Service
public class Authentication {

    @Autowired
    private AccountRepository repo;

    private String password;
    private String email;

//    public Authentication(String email, String password, AccountRepository repo) {
//        this.email = email;
//        this.password = password;
//        this.repo = repo;
//    }

    public Boolean isPassOfAccount() {
        String myPass = findPass();
        if (myPass !=  null) {
            if (myPass.equals(this.password)) {
                return true;
            }
        }
        return false;
    }

//    public boolean isAlreadyEmail() {
//        if (repo.existsEmail(this.email) != 0) {
//            return false;
//        }
//        else { return true; }
//    }

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
