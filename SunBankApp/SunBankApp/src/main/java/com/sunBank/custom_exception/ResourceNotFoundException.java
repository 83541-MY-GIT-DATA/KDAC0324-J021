package com.sunBank.custom_exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
