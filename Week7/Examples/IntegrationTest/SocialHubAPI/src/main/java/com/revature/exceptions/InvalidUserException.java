package com.revature.exceptions;

public class InvalidUserException extends RuntimeException{

    public InvalidUserException(){
        super("The username or email are invalid");
    }

}
