package com.example.webstore.controllers;

import com.example.webstore.models.AccountModels;
import com.example.webstore.models.CustomerModels;
import com.example.webstore.repository.AccountRepository;
import com.example.webstore.services.PasswordSecurity;
import com.example.webstore.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * The Account class provides controller for users can activities such as login, sign up.
 * @author Nguyen Thuan
 * @version 1.00 20 May 2022
 *
 * Modification Logs:
 *      DATE            AUTHOR          DESCRIPTION
 * ---------------------------------------------------------------------------------------
 *      30-May-2022     Nguyen Thuan    Encoded password before save into DB when register
 *      31-May-2022     Nguyen Thuan    Update code for use-case login consist of login and
 *                                      forget password.
 */
@Controller
public class Account {

    private Authentication author;
    private static String EMAIL = "";
    @Autowired
    private AccountRepository repoAccount;

    @Autowired
    private PasswordSecurity passwordSecurity;

//    @Autowired
//    private VerifyCodeRepository repoCode;

    @Autowired
    private UserServices services;

    @PostMapping("/login-author")
    public String Login(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass, HttpServletResponse response){

        // System.out.println(email + pass);

//        author = new Authentication(email, pass, repoAccount);

//        if (author.isPassOfAccount() == true) {
////            System.out.println("Đăng nhập thành công");
//            Cookie cookie = new Cookie("name", email);
//            response.addCookie(cookie);
//            return "redirect:/";
//        }
//        else {
//
////            System.out.println("Lỗi đăng nhập");
//            return "<h1>Đăng nhập thất bại</h1>";
//        }
        return "";
    }

     @PostMapping("/account/register")
     public String accountRegister(
                @RequestParam(value = "password") String  password,
                @ModelAttribute("user") CustomerModels cus,
                @ModelAttribute("account") @Valid AccountModels account,
                BindingResult bindingResult,
                HttpServletRequest request) {

         // check email already before ?
         if (bindingResult.hasErrors()) {
             return "signup";
         }
         EMAIL = account.getEmail();

        /**
         * 1. Create new account for a customer which just register.
         *     1.1. Encode password of user account, which inputted before.
         *          Then set password encoded for instance.
         *     1.2. Get time current and set it for instance.
         *     1.3. Set properties enabled of instance is false.
         */
         String encodePassword = passwordSecurity.passwordEncoder(password); // 1.1
         account.setPassword(encodePassword); // 1.1
         LocalDateTime timeCreate = LocalDateTime.now(); // 1.2
         DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss"); // 1.2
         account.setDateCreate(timeCreate.format(formatter)); // 1.2
         account.setEnabled(false); // 1.3

         cus.setAccountEmail(EMAIL);

         services.register(account, cus, getSiteUrl(request));

         return "redirect:/email/verify";
     }

     public String getSiteUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        return url.replace(request.getServletPath(), "");
     }

    @GetMapping("/verify")
    public String verifyAccount(@RequestParam("code") String code) {
        if (services.verify(EMAIL, code)) {

            return "redirect:/success";
        }
        return "redirect:/fail";
    }
}
