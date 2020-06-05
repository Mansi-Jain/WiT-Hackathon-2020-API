package com.withackathon.springApi.controller;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.withackathon.springApi.exception.HandleException;
import com.withackathon.springApi.response.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RestController
@CrossOrigin
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(HandleException.class)
	  public final ResponseEntity<Response> handleUserNotFoundException(HandleException ex, WebRequest request) {
		Response errorDetails = new Response(ex.getMessage());
	    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	  }

}
