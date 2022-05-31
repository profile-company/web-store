package com.example.webstore.controllers;

import com.example.webstore.dto.UserDto;
import com.example.webstore.models.AccountModels;
import com.example.webstore.models.CustomerModels;
import com.example.webstore.models.ProductModels;
import com.example.webstore.repository.ProductRepository;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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
    public String login(Model model) {

        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "login";
    }

    @GetMapping("/account/register")
    public  String register(Model model) {

        CustomerModels userDto = new CustomerModels();
        AccountModels accountDto = new AccountModels();

        model.addAttribute("user", userDto);
        model.addAttribute("account", accountDto);
        return "signup";
    }

    @GetMapping("/email/verify")
    public String emailVerify() {return "verify";}

    @GetMapping("/success")
    public String success() {return "success";}

    @GetMapping("/fail")
    public String fail() {return "fail";}

}

