package com.micro.service.one.exception;

public class ResponseErrorException extends RuntimeException {

	private static final long serialVersionUID = 5263513410276994541L;

	public ResponseErrorException() {
		super();
	}

	public ResponseErrorException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ResponseErrorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ResponseErrorException(String arg0) {
		super(arg0);
	}

	public ResponseErrorException(Throwable arg0) {
		super(arg0);
	}
}