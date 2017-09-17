package com.neu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.pojo.Property;


public class PropertyValidator implements Validator {

    public boolean supports(Class clazz)
    {
        return clazz.equals(Property.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Property property = (Property) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.property", "Price Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "area", "error.invalid.property", "Area Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usertype", "error.invalid.user", "Type Required");
    }
}
