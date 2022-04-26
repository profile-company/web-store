package com.example.webstore.controllers;

import com.example.webstore.models.AccountModels;
import com.example.webstore.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Account {

    @Autowired
    private AccountRepository repository;

    @GetMapping("/login")
    public String Login(){
        System.out.println("login");
        return "login";
    }

    @PostMapping("/login/failed")
    public String LoginFaile(){
        return "home";
    }

    @PostMapping("/checklogin")
    public String CheckLogin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, Model model){

        System.out.println(username + "  " + password);
        if (username == null || password == null) {
            // message error
            System.out.println("Error");
            return "login";
        }

        String data = repository.findPassword(username);
        if (data.equals(password)) {
//            AccountModels account = new Account(username, password);
//            model.addAttribute("account", account);
            return "home";
        }
        else {  return "login"; }

//        return "home";
    }
}
