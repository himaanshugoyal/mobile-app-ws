package com.himanshugoyal.tech.app.ws.exceptions;

public class MissingRequiredFieldException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7723823398650312936L;
	
	public MissingRequiredFieldException(String message)
	{
		super(message);
	}
}
