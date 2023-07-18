package com.mentoriatiago.integramarketplace.exceptions;

public class BadRequest extends RuntimeException{
    public BadRequest(String error){
        super(error);
    }
}
