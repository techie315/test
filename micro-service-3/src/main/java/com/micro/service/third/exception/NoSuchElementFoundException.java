package com.micro.service.third.exception;

import org.springframework.http.HttpStatus;

public class NoSuchElementFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private HttpStatus errorCode;
	private String errorMessage;
	
	public NoSuchElementFoundException() {
	}
	
	public NoSuchElementFoundException(HttpStatus errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
