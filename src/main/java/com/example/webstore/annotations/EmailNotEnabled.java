package com.example.webstore.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailNotEnabledValidator.class)
@Documented
public @interface EmailNotEnabled  {

    String message() default "Email not verification or existed already!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
