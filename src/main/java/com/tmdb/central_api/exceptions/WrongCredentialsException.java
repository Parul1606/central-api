package com.tmdb.central_api.exceptions;


public class WrongCredentialsException extends RuntimeException {
    public WrongCredentialsException(String message){
        super(message);
    }
}