package com.masai.bigbasket.exception;

public class InvalidEmailException extends  RuntimeException{
    public InvalidEmailException(String message) {
        super(message);
    }
}
