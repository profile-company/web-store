package com.example.webstore.controllers;

import com.example.webstore.dto.UserDto;
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

    private static String EMAIL = "";

    @Autowired
    private AccountRepository repoAccount;

    @Autowired
    private PasswordSecurity passwordSecurity;

    @Autowired
    private UserServices services;

    @PostMapping("/login")
    public String loginAccount(@ModelAttribute("user") @Valid UserDto userDto,
            BindingResult bindingResult,
            HttpServletResponse response){

//         System.out.println(userDto.toString());

         if (bindingResult.hasErrors()) {
//             System.out.println(bindingResult.getFieldError());
             return "login";
         }

//        System.out.println("Đăng nhập thành công");
        Cookie cookie = new Cookie("name", userDto.getEmail());
        response.addCookie(cookie);

        return "redirect:/";
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
