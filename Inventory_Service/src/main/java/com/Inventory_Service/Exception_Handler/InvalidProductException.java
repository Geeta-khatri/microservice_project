package com.Inventory_Service.Exception_Handler;

public class InvalidProductException extends RuntimeException {
	
	public InvalidProductException(String msg) {
		super(msg);
	}

}
