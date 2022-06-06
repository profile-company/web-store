package com.example.webstore.controllers;

import com.example.webstore.dto.UserDto;
import com.example.webstore.models.AccountModels;
import com.example.webstore.models.CustomerModels;
import com.example.webstore.repository.AccountRepository;
import com.example.webstore.services.AccountSingleton;
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

    /**
     * ...method loginAccount documentation comment...
     * get data from request in form. Authentication user account.
     * @param userDto save date sent from form.
     * @param bindingResult check error when login.
     * @param response use to send cookie.
     * @return return a view page.
     */
    @PostMapping("/login")
    public String loginAccount(@ModelAttribute("user") @Valid UserDto userDto,
            BindingResult bindingResult,
            HttpServletResponse response){

        // check error when button login clicked.
        if (bindingResult.hasErrors()) {
         return "login"; // redirect to view login.
        }

        AccountSingleton accountSingleton = AccountSingleton.getAccountSingleton();
        accountSingleton.setUserDto(userDto);

        Cookie cookie = new Cookie("name", accountSingleton.getUserDto()
                .getEmail().split("@")[0]);
        response.addCookie(cookie);

        return "redirect:/";
    }

    /**
     * ..method getSiteUrl documentation comment...
     * @param request get HttpServletRequest
     * @return return url to verify account.
     */
    public String getSiteUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        return url.replace(request.getServletPath(), "");
    }

    /**
     * ...method verifyAccount documentation comment...
     * @param code get code from request parameter code url.
     * @return return result.
     */
    @GetMapping("/verify")
    public String verifyAccount(@RequestParam("code") String code) {
        String email = AccountSingleton.getAccountSingleton().getUserDto().getEmail();
        if (services.verify(email, code)) {

            return "redirect:/success";
        }
        return "redirect:/fail";
    }
}
