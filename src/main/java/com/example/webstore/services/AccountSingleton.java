package com.example.webstore.services;

import com.example.webstore.dto.UserDto;

/**
 * The AccountSingleton class provides an instance (single and global access) for users
 * when login website.
 * @author Nguyen Thuan
 * @version 1.00 06 June 2022
 *
 * Modification Logs:
 *      DATE            AUTHOR          DESCRIPTION
 * ---------------------------------------------------------------------------------------
 *
 */
public class AccountSingleton {
    /* This class is a singleton class. */

    /**
     * userDto is on instance of UserDto object in this class.
     */
    private UserDto userDto;

    /**
     * ... constructor AccountSingleton documentation comment...
     *  is instance of this class.
     */
    private static AccountSingleton accountSingleton;

    // Private constructor.
    private AccountSingleton(){}

    /**
     * ...method getAccountSingleton documentation comment...
     * This method should be the only way of getting the Singleton object.
     */
    public static AccountSingleton getAccountSingleton() {
        // ...implementation goes here...

        // if an instance of class not created.
        if (accountSingleton == null) {
            return new AccountSingleton();
        }
        return accountSingleton;
    }

    /**
     * ...method setUserDto documentation comment...
     * @param userDto initialization object UserDto is a singleton.
     */
    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    /**
     * ...method getUserDto documentation comment...
     * @return return an object UserDto.
     */
    public UserDto getUserDto() {
        return userDto;
    }

    @Override
    public String toString() {
        return userDto.toString();
    }
}
