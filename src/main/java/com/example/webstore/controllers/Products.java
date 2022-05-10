package com.example.webstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Products {
    @GetMapping("/detail-products")
    public String productDetail(){
        return "DetailProduct";
    }
}
