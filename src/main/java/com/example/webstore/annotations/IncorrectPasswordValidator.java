package com.example.webstore.annotations;

import com.example.webstore.dto.UserDto;
import com.example.webstore.repository.AccountRepository;
import com.example.webstore.services.PasswordSecurity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IncorrectPasswordValidator implements
        ConstraintValidator<IncorrectPassword, UserDto> {

    @Autowired
    private AccountRepository repo;
    @Autowired
    private PasswordSecurity passwordSecurity;

    @Override
    public boolean isValid(UserDto userDto,
            ConstraintValidatorContext constraintValidatorContext) {

        String passwordEncode = repo.findPassword(userDto.getEmail());
        boolean flag = passwordSecurity.
                isPasswordMath(userDto.getPassword(), passwordEncode);

        return flag;
    }
}





