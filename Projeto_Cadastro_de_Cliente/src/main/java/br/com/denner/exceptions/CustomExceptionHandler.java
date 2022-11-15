package br.com.denner.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomExceptionHandler(String ex) {
		super(ex);
	}

	
}
