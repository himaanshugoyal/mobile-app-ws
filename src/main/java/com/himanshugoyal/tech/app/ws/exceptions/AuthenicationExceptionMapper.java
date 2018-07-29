/**
 * 
 */
package com.himanshugoyal.tech.app.ws.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ExceptionMapper;
import com.himanshugoyal.tech.app.ws.ui.model.response.ErrorMessage;
import com.himanshugoyal.tech.app.ws.ui.model.response.ErrorMessages;

/**
 * @author himanshugoyal
 *
 */
@Provider
public class AuthenicationExceptionMapper {
	public Response toResponse(AuthenticationException exception){
		ErrorMessage errorMessage = new ErrorMessage(
				exception.getMessage(),
				ErrorMessages.AUTHENTICATION_FAILED.name(),
				"http://tech.himanshugoyal.com"
		);
		
		return Response.status(Response.Status.UNAUTHORIZED).
				entity(errorMessage).
				build();
		
	}
}
