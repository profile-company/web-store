package com.example.webstore.controllers;

import com.example.webstore.models.CustomerModels;
import com.example.webstore.repository.AccountRepository;
import com.example.webstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Autowired
    private CustomerRepository repo;

//    @GetMapping("/test")
//    public String test() {
//        CustomerModels x = repo.findCustomer("thng@gmail.com");
//        System.out.println(x.toString());
//        return  x.toString();
//    }
}

