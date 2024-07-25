package com.api.employee.validation.annotation.validator;

import com.api.employee.validation.annotation.validator.annotaton.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // Custom password validation logic
        return password != null && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$");
    }
}
