package com.curso.dslist.exceptions;

public class GameNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public GameNotFoundException(String msg) {
		super(msg);
	}

}
