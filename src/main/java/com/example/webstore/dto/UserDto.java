package com.example.webstore.dto;

import com.example.webstore.annotations.EmailNotEnabled;
import com.example.webstore.annotations.IncorrectPassword;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The UserDto class Data Transfer Object to send all login information to Spring
 * backend
 * @author Nguyen Thuan
 * @version 1.00 31 May 2022
 *
 * Modification Logs:
 *      DATE            AUTHOR          DESCRIPTION
 * -------------------------------------------------------------------------
 *      31-May-2022     Nguyen Thuan    Implement class
 */

@IncorrectPassword
public class UserDto {

    @EmailNotEnabled
    private String email;

    private String password;

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" + "email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }
}
