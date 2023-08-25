package com.masaischool.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyExceptionClass> myException(Exception ex, WebRequest web) {
		MyExceptionClass mec = new MyExceptionClass(ex.getMessage(), web.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<MyExceptionClass>(mec, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyExceptionClass> myException(NoHandlerFoundException ex, WebRequest web) {
		MyExceptionClass mec = new MyExceptionClass(ex.getMessage(), web.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<MyExceptionClass>(mec, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyExceptionClass> myException(MethodArgumentNotValidException ex, WebRequest web) {
		MyExceptionClass mec = new MyExceptionClass("Valiation Failed", web.getDescription(false), LocalDateTime.now());
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		List<String> errorsToStringList = MethodArgumentNotValidException.errorsToStringList(allErrors);

		String str = String.join(",", errorsToStringList);

		mec.setDescription(str);

		return new ResponseEntity<MyExceptionClass>(mec, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(VaccineNotFoundException.class)
	public ResponseEntity<MyExceptionClass> myException(VaccineNotFoundException ex, WebRequest web) {
		MyExceptionClass mec = new MyExceptionClass(ex.getMessage(), web.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<MyExceptionClass>(mec, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidMemberException.class)
	public ResponseEntity<MyExceptionClass> getInvalidMemberException(InvalidMemberException ime, WebRequest req) {
		MyExceptionClass mec = new MyExceptionClass(ime.getMessage(), req.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<MyExceptionClass>(mec, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<MyExceptionClass> getInvalidUserException(InvalidUserException iue, WebRequest req) {
		MyExceptionClass mec = new MyExceptionClass(iue.getMessage(), req.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<MyExceptionClass>(mec, HttpStatus.NOT_FOUND);
	}
}
