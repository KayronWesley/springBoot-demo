package com.example.springbootDemo.resource.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springbootDemo.services.exceptions.DatabaseException;
import com.example.springbootDemo.services.exceptions.ResourceNotFindException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFindException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFindException e, HttpServletRequest req){
		String error = "Resource Not Find";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(status).body(err);
				
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> dbError(DatabaseException e, HttpServletRequest req){
		String error = "Data Base Error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(status).body(err);
				
	}
	
	

}
