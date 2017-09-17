package com.neu.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.pojo.User;

public class LoginValidator implements Validator {
	
	 private Pattern comparePattern;  
	  private Matcher compareMatcher;
	  String STRING_PATTERN = "[a-zA-Z]+";

    public boolean supports(Class clazz)
    {
        return clazz.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailId", "error.invalid.email.emailId", "Email Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usertype", "error.invalid.usertype", "Type Required");
       
        if (!(user.getUsername() != null && user.getUsername().isEmpty())) {  
        	comparePattern = Pattern.compile(STRING_PATTERN);  
        	compareMatcher = comparePattern.matcher(user.getUsername());  
         if (!compareMatcher.matches()) {  
          errors.rejectValue("username", "user.containNonChar",  
            "Enter a valid Username");  
         }  
        } 
        
    }
    
}
