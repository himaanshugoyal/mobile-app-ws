/**
 * 
 */
package com.himanshugoyal.tech.app.ws.service.impl;

import com.himanshugoyal.tech.app.ws.exceptions.AuthenticationException;
import com.himanshugoyal.tech.app.ws.service.AuthenticationService;
import com.himanshugoyal.tech.app.ws.service.UsersService;
import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;
import com.himanshugoyal.tech.app.ws.ui.model.response.ErrorMessages;
import com.himanshugoyal.tech.app.ws.utils.UserProfileUtils;

/**
 * @author himanshugoyal
 *
 */
public class AuthenticationServiceImp implements AuthenticationService {

	public UserDTO authenticate(String userName, String password) throws AuthenticationException {
		UsersService usersService = new UsersServiceImpl();
		UserDTO storedUser = usersService.getUserByUserName(userName);// Username must be unique in the database
		
		if(storedUser == null){
			throw new AuthenticationException(ErrorMessages.AUTHENTICATION_FAILED.getErrorMessage());
		}
		
		String encryptedPassword = null;
		
		encryptedPassword = new UserProfileUtils().
				generateSecurePassword(password, storedUser.getSalt());
			
		boolean authenticated = false;
		if(encryptedPassword != null && encryptedPassword.equalsIgnoreCase(storedUser.getEncryptedPassword()))
			if(userName != null && userName.equalsIgnoreCase(storedUser.getEmail())){
				authenticated = true;
			}
		
		if(!authenticated){
			throw new AuthenticationException(ErrorMessages.AUTHENTICATION_FAILED.getErrorMessage());
		}
		return storedUser;
	}

}
