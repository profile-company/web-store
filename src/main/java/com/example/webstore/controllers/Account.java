package com.example.webstore.controllers;

import com.example.webstore.models.AccountModels;
import com.example.webstore.models.CustomerModels;
import com.example.webstore.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.List;

@Controller
public class Account {

    private Author author;
    @Autowired
    private AccountRepository repository;

    @PostMapping("/login-author")
    public String Login(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass, HttpServletResponse response){

        // System.out.println(email + pass);

        author = new Author(email, pass, repository);

        if (author.isPassOfAccount() == true) {
            System.out.println("Đăng nhập thành công");
            Cookie cookie = new Cookie("name", email);
            response.addCookie(cookie);
            return "redirect:/";
        }
        else {

            System.out.println("Lỗi đăng nhập");
            return "<h1>Đăng nhập thất bại</h1>";
        }
    }

     @PostMapping("/verify-registration")
     public String verifyRegistration(@RequestParam(value = "confirm_pass") String confirmPass,
                                      @RequestParam(value = "password") String  password,
                                      @RequestParam(value = "sex") String sex,
                                      @ModelAttribute("user") CustomerModels cus){

        System.out.println(cus.toString());
        System.out.println(confirmPass);
        System.out.println(sex);

         return "home";
     }

//     @PostMapping("/checklogin")
//     public String CheckLogin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, Model model){

//         System.out.println(username + "  " + password);
//         if (username == null || password == null) {
//             // message error
//             System.out.println("Error");
//             return "login";
//         }

//         String data = repository.findPassword(username);
//         if (data.equals(password)) {
// //            AccountModels account = new Account(username, password);
// //            model.addAttribute("account", account);
//             return "home";
//         }
//         else {  return "login"; }

// //        return "home";
//     }
}
