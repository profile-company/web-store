package com.example.webstore.controllers;

import com.example.webstore.models.AccountModels;
import com.example.webstore.models.CustomerModels;
import com.example.webstore.models.VerifyCode;
import com.example.webstore.repository.AccountRepository;
import com.example.webstore.repository.VerifyCodeRepository;
import com.example.webstore.services.UserServices;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.HttpConstraintElement;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class Account {

    private Author author;
    private static String EMAIL = "";
    @Autowired
    private AccountRepository repository;

    @Autowired
    private VerifyCodeRepository repoCode;

    @Autowired
    private UserServices services;

    @PostMapping("/login-author")
    public String Login(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass, HttpServletResponse response){

        // System.out.println(email + pass);

        author = new Author(email, pass, repository);

        if (author.isPassOfAccount() == true) {
//            System.out.println("Đăng nhập thành công");
            Cookie cookie = new Cookie("name", email);
            response.addCookie(cookie);
            return "redirect:/";
        }
        else {

//            System.out.println("Lỗi đăng nhập");
            return "<h1>Đăng nhập thất bại</h1>";
        }
    }

     @PostMapping("/verify-registration")
     public String verifyRegistration(@RequestParam(value = "confirm_pass") String confirmPass,
                                      @RequestParam(value = "password") String  password,
                                      @RequestParam(value = "sex") String sex,
                                      @ModelAttribute("user") CustomerModels cus,
                                      HttpServletRequest request){



        //
         String email = cus.getAccountEmail();
         LocalDateTime timeCreate = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         String timeCreateFormatted = timeCreate.format(formatter);
         int isEmailAlready = repository.existsEmail(email);


        // check email already before ?
        if (isEmailAlready > 0) {
            return "redirect:/verify-registration";
        }


        EMAIL = cus.getAccountEmail();
        AccountModels newAccount = new AccountModels(email, password,timeCreateFormatted, false);


        services.register(newAccount,cus ,getSiteUrl(request));

         return "redirect:/email/verify";
     }

     public String getSiteUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        return url.replace(request.getServletPath(), "");
     }

    @GetMapping("/verify")
    public String verifyAccount(@RequestParam("code") String code) {
        if (services.verify(EMAIL, code)) {

            VerifyCode verifyCode = new VerifyCode();
            verifyCode.setCode(null);
            verifyCode.setEmail(EMAIL);
            repoCode.save(verifyCode);

            return "redirect:/success";
        }
        return "redirect:/fail";
    }
}
