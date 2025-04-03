package com.example.abhay.WhatchListApllication.Entity.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriorityAnotationLogic.class)
public @interface Priority {
    String message() default "please enter LMH ";

    Class<?>[]groups() default{};
    Class<? extends Payload>[] payload() default {};

}
