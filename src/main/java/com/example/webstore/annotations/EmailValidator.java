package com.example.webstore.annotations;

import com.example.webstore.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailValidation, String> {

    @Autowired
    AccountRepository accountRep;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (this.accountRep == null) {
            return false;
        }

        int count = accountRep.existsEmail(s);

        if (count >= 1) {
            return false;
        }
        else {
            return true;
        }
    }
}
