package com.example.day17.Exceptions;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
