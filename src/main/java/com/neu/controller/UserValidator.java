package com.neu.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.pojo.User;

public class UserValidator implements Validator {

	  private Pattern comparePattern;  
	  private Matcher compareMatcher;  
	  private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
	      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	  String STRING_PATTERN = "[a-zA-Z]+";	
	
    public boolean supports(Class clazz)
    {
        return clazz.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailId", "error.invalid.email.emailId", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usertype", "error.invalid.usertype", "Type Required");
        
        if (!(user.getEmail().getEmailId() != null && user.getEmail().getEmailId().isEmpty())) {  
            comparePattern = Pattern.compile(EMAIL_PATTERN);  
            compareMatcher = comparePattern.matcher(user.getEmail().getEmailId());  
            if (!compareMatcher.matches()) {  
             errors.rejectValue("email.emailId", "email.emailId.incorrect",  
               "Enter a correct email");  
            }  
           } 
        if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {  
        	comparePattern = Pattern.compile(STRING_PATTERN);  
        	compareMatcher = comparePattern.matcher(user.getFirstName());  
            if (!compareMatcher.matches()) {  
             errors.rejectValue("firstName", "user.containNonChar",  
               "Enter a valid First name");  
            }  
           }  
        if (!(user.getLastName() != null && user.getLastName().isEmpty())) {  
        	comparePattern = Pattern.compile(STRING_PATTERN);  
        	compareMatcher = comparePattern.matcher(user.getLastName());  
            if (!compareMatcher.matches()) {  
             errors.rejectValue("lastName", "user.containNonChar",  
               "Enter a valid Last name");  
            }  
           }  
        if (!(user.getUsername() != null && user.getUsername().isEmpty())) {  
        	comparePattern = Pattern.compile(STRING_PATTERN);  
        	compareMatcher = comparePattern.matcher(user.getUsername());  
         if (!compareMatcher.matches()) {  
          errors.rejectValue("username", "user.containNonChar",  
            "Enter a valid Username");  
         }  
        } 
        if (!(user.getPassword() != null && user.getPassword().isEmpty())) { 
        if (user.getPassword().toString().length() < 8) {  
            errors.rejectValue("password", "password.less",  
              "Password should contain minimum 8 characters");  
           }  
          }
    
        
    }
}
