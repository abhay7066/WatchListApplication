package com.example.abhay.WhatchListApllication.Entity.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriorityAnotationLogic implements ConstraintValidator<Priority,String>
{


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.trim().length()==1 && "LHM".contains(s.trim());
    }
}
