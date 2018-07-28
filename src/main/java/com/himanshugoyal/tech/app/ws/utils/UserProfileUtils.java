/**
 * 
 */
package com.himanshugoyal.tech.app.ws.utils;

import com.himanshugoyal.tech.app.ws.exceptions.MissingRequiredFieldException;
import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;
import com.himanshugoyal.tech.app.ws.ui.model.response.ErrorMessages;

/**
 * @author himanshugoyal
 *
 */
public class UserProfileUtils {
	public void validateRequiredFields(UserDTO userDto) throws MissingRequiredFieldException{
		if(userDto.getFirstName() == null ||
				userDto.getLastName().isEmpty() ||
				userDto.getLastName()==null || 
				userDto.getLastName().isEmpty() ||
				userDto.getEmail() == null ||
				userDto.getEmail().isEmpty()||
				userDto.getPassword() == null ||
				userDto.getPassword().isEmpty()){
			throw new MissingRequiredFieldException(
				ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
			}	
	}
}
