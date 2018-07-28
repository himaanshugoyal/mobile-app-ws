/**
 * 
 */
package com.himanshugoyal.tech.app.ws.service.impl;

import com.himanshugoyal.tech.app.ws.exceptions.CouldNotCreateRecordException;
import com.himanshugoyal.tech.app.ws.io.dao.DAO;
import com.himanshugoyal.tech.app.ws.io.dao.impl.MySQLDAO;
import com.himanshugoyal.tech.app.ws.service.UsersService;
import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;
import com.himanshugoyal.tech.app.ws.ui.model.response.ErrorMessages;
import com.himanshugoyal.tech.app.ws.utils.UserProfileUtils;

/**
 * @author himanshugoyal
 *
 */
public class UsersServiceImpl implements UsersService {
	
	DAO database ;
	
	public UsersServiceImpl(){
		this.database = new MySQLDAO();
	}
	UserProfileUtils userProfileUtils = new UserProfileUtils();
	
	public UserDTO createUser(UserDTO user){
		UserDTO returnValue = new UserDTO();
		
		// Validate the required fields
		userProfileUtils.validateRequiredFields(user);
		
		// Check if user already exists
		UserDTO existingUser = this.getUserByUserName(user.getEmail());
		if(existingUser != null){
			throw new CouldNotCreateRecordException(ErrorMessages.RECORD_ALREADY_EXISTS.name());
		}
		// Create and Entity object
		
		// Generate Secure public user id
		
		// Generate salt
		
		// Generate Secure Password
		
		// Record data into a database
		
		// Return Back the user profile
		
		return returnValue;
	}
	
	private UserDTO getUserByUserName(String userName){
		UserDTO userDto = null;
		
		if(userName == null || userName.isEmpty()){
			return userDto;
		}
		
		//connect to database
		try{
			this.database.openConnection();
			userDto = this.database.getUserByUserName(userName);
		}finally{
			this.database.closeConnection();
		}
		
		return userDto;
	}
	
}
