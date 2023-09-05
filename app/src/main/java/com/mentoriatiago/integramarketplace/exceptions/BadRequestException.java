package com.mentoriatiago.integramarketplace.exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String error){
        super(error);
    }

}
