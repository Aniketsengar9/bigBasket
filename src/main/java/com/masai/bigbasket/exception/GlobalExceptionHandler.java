package com.masai.bigbasket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ErrorDetails> InvalidEmailExceptionHandler(InvalidEmailException ex, WebRequest request){
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(ex.getMessage());
		ed.setUri(request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> NotFoundExceptionHandler(NotFoundException ex, WebRequest request){
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(ex.getMessage());
		ed.setUri(request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
}
