/**
 * 
 */
package com.himanshugoyal.tech.app.ws.exceptions;

/**
 * @author himanshugoyal
 *
 */
public class AuthenticationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1575804241788246959L;

	public AuthenticationException(String message)
	{
		super(message);
	}
}
