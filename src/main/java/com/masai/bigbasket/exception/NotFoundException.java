package com.masai.bigbasket.exception;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
