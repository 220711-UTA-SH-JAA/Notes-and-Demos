package com.example.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.models.User;


//The Validator interface comes with Spring Boot, as well as Spring Errors, and DataBinder
public class UserValidation implements Validator{

	//There are two methods we must implmement, supports, validate
	//This will be called first, to make sure we are actually passing it the correct object
	@Override
	public boolean supports(Class<?> clazz) {
		//We need to make sure that a User class is actually passed, because we can't for example
		//Validate a User class vs Item class
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//If the object passed the support method, then the validate method is called
		//Make sure we pass in all the relevant information for user
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "user must have a first name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",  "lastName.empty", "user must have a last name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty", "user must have a username");
		
		User u = (User) target;
		
		if(u.getUserId() > 0) {
			errors.rejectValue("userId", "invalid.userId", "When registering, user has no id");
		}
		
		if(u.getPassword().length() < 8) {
			errors.rejectValue("password", "invalid.password", "The password must be more than 8 characters");
		}
		
	}
	
}
