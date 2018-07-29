/**
 * 
 */
package com.himanshugoyal.tech.app.ws.service.impl;

import com.himanshugoyal.tech.app.ws.exceptions.CouldNotCreateRecordException;
import com.himanshugoyal.tech.app.ws.exceptions.NoRecordFoundException;
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
		UserDTO returnValue = null;

		// Validate the required fields
		userProfileUtils.validateRequiredFields(user);

		// Check if user already exists
		UserDTO existingUser = this.getUserByUserName(user.getEmail());
		if(existingUser != null){
			throw new CouldNotCreateRecordException(ErrorMessages.RECORD_ALREADY_EXISTS.name());
		}

		// Create and Entity object - Not Needed Now, implemented now.

		// Generate Secure public user id
		String userId = userProfileUtils.generateUserId(30);
		user.setUserId(userId);

		// Generate salt
		/*
		 * https://docs.oracle.com/javase/7/docs/api/javax/crypto/spec/PBEKeySpec.html
		 */
		String salt = userProfileUtils.getSalt(30);

		// Generate Secure Password
		String encryptedPassword = userProfileUtils.generateSecurePassword(user.getPassword(), salt);
		user.setSalt(salt);
		user.setEncryptedPassword(encryptedPassword);

		// Record data into a database
		returnValue = this.saveUser(user);

		// Return Back the user profile

		return returnValue;
	}
	
	public UserDTO getUser(String id){
		UserDTO returnValue = null;
		try{
			
			this.database.openConnection();
			returnValue = this.database.getUser(id);
			
		}catch( Exception ex){
			ex.printStackTrace();
			throw new NoRecordFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}finally {
			this.database.closeConnection();
		}
		return returnValue;
	}
	
	public UserDTO getUserByUserName(String userName){
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

	private UserDTO saveUser(UserDTO user){
		UserDTO returnValue = null;

		//connect to database
		try{
			this.database.openConnection();
			returnValue = this.database.saveUser(user);
		}finally{
			this.database.closeConnection();
		}
		
		return returnValue;
		
	}

}
