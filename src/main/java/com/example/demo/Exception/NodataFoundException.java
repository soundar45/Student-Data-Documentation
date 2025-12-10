package com.example.demo.Exception;


public class NodataFoundException extends RuntimeException{
    public NodataFoundException(String message){
        super(message);
    }

}
