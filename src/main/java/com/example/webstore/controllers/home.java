package com.example.webstore.controllers;

import com.example.webstore.dto.ShowProduct;
import com.example.webstore.dto.UserDto;
import com.example.webstore.models.AccountModels;
import com.example.webstore.models.CustomerModels;
import com.example.webstore.models.ProductModels;
import com.example.webstore.repository.ProductRepository;
import com.example.webstore.services.ProductFactory;
import com.example.webstore.services.ShowProductConcrete;
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

    @Autowired
    ShowProductConcrete factory;

    /**
     * ...home method documentation comment...
     * Handle requests home page.
     * @param model to render data into view.
     * @return show home page.
     */
    @GetMapping("/")
    public String home(Model model){

        List<Integer> listId = productRepo.getAllIdProduct();

        if (listId == null) {
            throw new ArithmeticException("Not found all id product!");
        }

        List<ShowProduct> listProducts =
                new ArrayList<ShowProduct>();

        for (int item:listId) {

            ShowProduct product = (ShowProduct) factory.createProduct(item);
            listProducts.add(product);
        }

        model.addAttribute("products", listProducts);

        return "home";
    }

    /**
     * ...methode login documentation comment...
     * @param model supply attributes used for rendering view be returned.
     * @return return view login.
     */
    @GetMapping("/login")
    public String login(Model model) {

        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "login";
    }

    /**
     * ...method register documentation comment...
     * @param model supply attributes used for rendering view be returned.
     * @return return view signup.
     */
    @GetMapping("/account/register")
    public  String register(Model model) {

        CustomerModels userDto = new CustomerModels();
        AccountModels accountDto = new AccountModels();

        model.addAttribute("user", userDto);
        model.addAttribute("account", accountDto);
        return "signup";
    }

    /**
     * show page message for user verification email.
     * @return verify page.
     */
    @GetMapping("/email/verify")
    public String emailVerify() {return "verify";}

    @GetMapping("/success")
    public String success() {return "success";}

    @GetMapping("/fail")
    public String fail() {return "fail";}

    @GetMapping("/login-admin")
    public String loginAdmin(Model model) {

        // admin
        return "login";
    }

}

