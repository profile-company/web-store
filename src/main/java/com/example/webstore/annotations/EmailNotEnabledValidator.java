package com.example.webstore.annotations;

import com.example.webstore.dto.UserDto;
import com.example.webstore.models.AccountModels;
import com.example.webstore.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailNotEnabledValidator implements
        ConstraintValidator<EmailNotEnabled, String> {

    @Autowired
    private AccountRepository repo;

    private boolean isEnabledEmail(String email) {

        AccountModels accountModels = repo.findEnabledByEmail(email);
        System.out.println(accountModels.toString());
        if (accountModels == null) {
            return false;
        }
        return accountModels.isEnabled();
    }

    @Override
    public boolean isValid(String email,
            ConstraintValidatorContext constraintValidatorContext) {

        return isEnabledEmail(email);
    }
}
