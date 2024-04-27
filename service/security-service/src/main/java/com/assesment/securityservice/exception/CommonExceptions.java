package com.assesment.securityservice.exception;

import com.assesment.securityservice.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptions {
	
	Logger log = LoggerFactory.getLogger(CommonExceptions.class);
	

	

	@ExceptionHandler({OperationFailedException.class})
	public ResponseDTO<String> handleException(OperationFailedException e){
		log.warn("Some Exception has Occurred....See the logs above and below.");
		return new ResponseDTO<>(false,"Operation Failed",null);
	}
	

}
