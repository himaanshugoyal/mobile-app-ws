/**
 * 
 */
package com.himanshugoyal.tech.app.ws.ui.entrypoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.himanshugoyal.tech.app.ws.exceptions.AuthenticationException;
import com.himanshugoyal.tech.app.ws.service.AuthenticationService;
import com.himanshugoyal.tech.app.ws.service.impl.AuthenticationServiceImp;
import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;
import com.himanshugoyal.tech.app.ws.ui.model.request.LoginCredentials;
import com.himanshugoyal.tech.app.ws.ui.model.response.AuthenticatonDetails;

/**
 * @author himanshugoyal
 *
 */
@Path("/authentication")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class AuthenticationEntryPoint {
	public AuthenticatonDetails userLogin(LoginCredentials loginCredentials){
		AuthenticatonDetails returnValue = new AuthenticatonDetails();
		
		AuthenticationService authenticationService = new AuthenticationServiceImp();
		UserDTO authenticatedUser = authenticationService.authenticate(loginCredentials.getUserName(), loginCredentials.getUserPassword());
		
		return returnValue;
	}
}
