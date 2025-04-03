package com.example.abhay.WhatchListApllication.Entity.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RattingAnotationLogic.class)
public @interface Ratting {

    String message() default "please enter value between 5 to 10  ";

    Class<?>[]groups() default{};
    Class<? extends Payload>[] payload() default {};

}
