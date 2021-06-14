package com.micro.service.third.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.micro.service.third.exception.NoSuchElementFoundException;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<String> handleEmptyInput(NoSuchElementFoundException emptyInputException) {
		return new ResponseEntity<String>(emptyInputException.getErrorMessage() ,emptyInputException.getErrorCode());
	}
}
