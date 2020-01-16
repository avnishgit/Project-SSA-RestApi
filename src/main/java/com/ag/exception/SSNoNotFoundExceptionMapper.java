package com.ag.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class SSNoNotFoundExceptionMapper {

	@ExceptionHandler(SSNoNotFounException.class)
	public ResponseEntity<ErrorResponce> m1() {
		ErrorResponce resBody = new ErrorResponce();
		resBody.setErroCode("CRAP001");
		resBody.setErrorDesc("Invalid Person SSNo");
		ResponseEntity<ErrorResponce> entity = new ResponseEntity<ErrorResponce>(resBody, HttpStatus.BAD_REQUEST);
		return entity;
	}
}
