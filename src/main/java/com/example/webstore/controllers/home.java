package com.example.webstore.controllers;

import com.example.webstore.models.CustomerModels;
import com.example.webstore.models.ProductModels;
import com.example.webstore.repository.ProductRepository;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class home {

    @Autowired
    ProductRepository productRepo;

    @GetMapping("/")
    public String home(Model model){

        List<ProductModels> listProducts = productRepo.getAllProducts();

        //ProductModels productDto = new ProductModels();
//        productDto.setName("Thuan");
//        System.out.println(listProducts.get(0));

        model.addAttribute("products", listProducts);

        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/account/register")
    public  String register(Model model) {
        CustomerModels userDto = new CustomerModels();

        model.addAttribute("user", userDto);
        return "sigin";
    }

    @GetMapping("/email/verify")
    public String emailVerify() {return "verify";}

    @GetMapping("/success")
    public String success() {return "success";}

    @GetMapping("/fail")
    public String fail() {return "fail";}

    @GetMapping("/cart")
    public String cart() {

        return "cart";
    }
}

