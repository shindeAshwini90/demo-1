package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalControllerExceptionHandler {

	 @ExceptionHandler(BussinessException.class)
	 public ResponseEntity<ErrorDetails> handleBussinessException(HttpServletRequest request, BussinessException ex){
		 ErrorDetails details = new ErrorDetails();
		 details.setMgs(ex.getMessage());
		 details.setStatusCode(HttpStatus.BAD_REQUEST.value());
		 ResponseEntity<ErrorDetails> res = new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
		return res;
	 }
	 
	 @ExceptionHandler(ValidationException.class)
	 public ResponseEntity<ErrorDetails> handleValidationExceptionException(ValidationException ex){
		 ErrorDetails details = new ErrorDetails();
		 details.setMgs(ex.getMessage());
		 details.setStatusCode(HttpStatus.BAD_REQUEST.value());
		 ResponseEntity<ErrorDetails> res = new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
		return res;
	 }

}
