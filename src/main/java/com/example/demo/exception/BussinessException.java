package com.example.demo.exception;

public class BussinessException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private String message;
	public BussinessException(String mgs) {
		super(mgs);
		this.message = mgs;
	}
	
	public String getMessage() {
		return message;
	}
	
	

}
