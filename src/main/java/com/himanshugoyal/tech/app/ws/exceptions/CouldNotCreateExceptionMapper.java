package com.himanshugoyal.tech.app.ws.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.himanshugoyal.tech.app.ws.ui.model.response.ErrorMessage;
import com.himanshugoyal.tech.app.ws.ui.model.response.ErrorMessages;

@Provider
public class CouldNotCreateExceptionMapper  implements ExceptionMapper<CouldNotCreateRecordException>{

	public Response toResponse(CouldNotCreateRecordException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 
				ErrorMessages.RECORD_ALREADY_EXISTS.name(), 
				"http://himanshugoyal.com");
		
		// TODO Auto-generated method stub
		return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
	}

}

