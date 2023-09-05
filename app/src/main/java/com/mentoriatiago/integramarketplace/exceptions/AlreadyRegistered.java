package com.mentoriatiago.integramarketplace.exceptions;

public class AlreadyRegistered extends RuntimeException{

    public AlreadyRegistered(String error){
        super(error);
    }

}
