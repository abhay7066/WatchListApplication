package com.example.abhay.WhatchListApllication.Entity.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RattingAnotationLogic implements ConstraintValidator<Ratting,Float> {
    @Override
    public boolean isValid(Float aFloat, ConstraintValidatorContext constraintValidatorContext) {
        return aFloat>=5 && aFloat<=10;
    }
}
