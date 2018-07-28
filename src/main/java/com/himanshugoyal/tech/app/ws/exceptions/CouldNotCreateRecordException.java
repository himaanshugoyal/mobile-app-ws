/**
 * 
 */
package com.himanshugoyal.tech.app.ws.exceptions;

/**
 * @author himanshugoyal
 *
 */
public class CouldNotCreateRecordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7723823398650312936L;
	
	public CouldNotCreateRecordException(String message)
	{
		super(message);
	}
}
