package com.project.bank.advice;

import java.util.NoSuchElementException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.bank.customException.CustomException;



@ControllerAdvice
public class AdviceClass extends ResponseEntityExceptionHandler {

	//1. System Exception
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException)
	{
		return new ResponseEntity<String>("Invalid ID!! No Such Element Exists!!", HttpStatus.NOT_FOUND);
	}
	
	//2. Custom Exception
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleCommonException(CustomException commonException)
	{
		return new ResponseEntity<String>(commonException.getErrorMessage(), commonException.getErrorCode());
	}
	
	//3. Request Method Invalid Exception
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>("Invalid HTTP Request Method Type!!", HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
//	// 4. System Exception for Validations
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
//		return new ResponseEntity<String>("Validation Error!!",HttpStatus.BAD_REQUEST);
//	}
	
	
}
