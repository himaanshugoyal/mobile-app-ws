/**
 * 
 */
package com.himanshugoyal.tech.app.ws.ui.model.response;

/**
 * @author himanshugoyal
 *
 */
public enum ErrorMessages {
	
	RECORD_ALREADY_EXISTS("Missing required fields."),
	MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
	INTERNAL_SERVER_ERROR("Internal Server Error");
	private String errorMessage;
	
	ErrorMessages (String errorMessage){
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
