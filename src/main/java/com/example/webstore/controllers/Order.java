package com.example.webstore.controllers;

import com.example.webstore.models.OrderItemModels;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Order {

    @PostMapping("/checkout")
    String processOrder(@ModelAttribute("OrderItems") OrderItemModels orderItems,
                        @RequestParam(value = "id") String id){

        System.out.println(orderItems.toString());
        return "cart";
    }
}
