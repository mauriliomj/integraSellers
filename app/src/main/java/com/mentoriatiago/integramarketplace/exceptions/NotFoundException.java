package com.mentoriatiago.integramarketplace.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String error){
        super(error);
    }

}
