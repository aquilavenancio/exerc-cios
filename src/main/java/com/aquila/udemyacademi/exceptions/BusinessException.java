package com.aquila.udemyacademi.exceptions;

public class BusinessException extends Exception{

    private final int status;

    public BusinessException(String messageException, int status){
        super(messageException);
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
    
}
