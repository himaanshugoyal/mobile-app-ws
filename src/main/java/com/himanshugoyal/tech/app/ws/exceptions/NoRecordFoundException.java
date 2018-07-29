/**
 * 
 */
package com.himanshugoyal.tech.app.ws.exceptions;

/**
 * @author himanshugoyal
 *
 */
public class NoRecordFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2265541691069671381L;

	public NoRecordFoundException(String message){
		super(message);
	}
}
