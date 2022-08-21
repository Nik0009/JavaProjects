package com.example.jpa.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidExcetion(MethodArgumentNotValidException ex){
		
		 Map<String,String> resp=new HashMap<>();
		 ex.getBindingResult().getAllErrors().forEach((error) ->{
			 String fieldName = ((FieldError)error).getField();
			 String message = error.getDefaultMessage();
			 resp.put(fieldName, message);
			 
		 });
		 
		 return new ResponseEntity<Map<String,String>> (resp,HttpStatus.BAD_REQUEST);
	}
}
