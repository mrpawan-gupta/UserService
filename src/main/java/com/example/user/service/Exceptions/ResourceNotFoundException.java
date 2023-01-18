package com.example.user.service.Exceptions;

public class ResourceNotFoundException extends RuntimeException{

    /*
    Extra properties cna be managed in this custom exception
    */
    public ResourceNotFoundException() {
        super("Resource not found on server !!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}