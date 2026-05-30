package com.OrderService.ExceptionHandler;


public class InvalidOrderException extends RuntimeException{
	
	
	
	public InvalidOrderException(String msg) {
		super(msg);
	}

}
