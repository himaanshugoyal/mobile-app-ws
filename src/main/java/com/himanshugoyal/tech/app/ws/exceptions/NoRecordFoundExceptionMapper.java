/**
 * 
 */
package com.himanshugoyal.tech.app.ws.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.himanshugoyal.tech.app.ws.ui.model.response.ErrorMessage;
import com.himanshugoyal.tech.app.ws.ui.model.response.ErrorMessages;

/**
 * @author himanshugoyal
 *
 */
@Provider
public class NoRecordFoundExceptionMapper implements ExceptionMapper<NoRecordFoundException>{

	public Response toResponse(NoRecordFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 
				ErrorMessages.NO_RECORD_FOUND.name(), 
				"http://appsdeveloper.com");
		
		// TODO Auto-generated method stub
		return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
	}

}

