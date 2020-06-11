package com.mycompany.ecommerce;

import java.util.Locale;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This class provide, the methods that applied to all REST API controllers
 * class in our application.
 * 
 * @author oguzhankinik
 *
 */
@ControllerAdvice
public class RestApiExceptionHandler {

	/**
	 * This handler method triggers with domain @Valid annotation in request body.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleArgumentNotValidException(MethodArgumentNotValidException ex, Locale locale) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getAllErrors()
                .stream()
                .map(objectError -> messageSource.getMessage(objectError, locale))
                .collect(Collectors.toList());
        return new ResponseEntity<>(new RestMessage(errorMessages), HttpStatus.BAD_REQUEST);
    }
	
}
