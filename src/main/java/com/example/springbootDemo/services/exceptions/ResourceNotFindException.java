package com.example.springbootDemo.services.exceptions;

public class ResourceNotFindException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFindException(Object id) {
		super("Resource not find: ID " + id);
	}

}
