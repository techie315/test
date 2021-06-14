package com.micro.service.one.exception.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResponseErrorHandler;

import com.micro.service.one.dto.RequestErrorResponse;
import com.micro.service.one.exception.ResponseErrorException;

@ControllerAdvice
public class RequestExceptionHandler implements ResponseErrorHandler {

	@ExceptionHandler
	public ResponseEntity<RequestErrorResponse> handleException(ResponseErrorException exc) {
		RequestErrorResponse error = new RequestErrorResponse(HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<RequestErrorResponse> handleException(Exception exc) {
		RequestErrorResponse error = new RequestErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
	}

}
