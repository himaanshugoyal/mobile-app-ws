/**
 * 
 */
package com.himanshugoyal.tech.app.ws.utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import com.himanshugoyal.tech.app.ws.exceptions.MissingRequiredFieldException;
import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;
import com.himanshugoyal.tech.app.ws.ui.model.response.ErrorMessages;

/**
 * @author himanshugoyal
 *
 */
public class UserProfileUtils {
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqwrstuvwxyz";
	
	/*A UUID (Universal Unique Idnetifier) is a 128-bit number used to uniquely identify some object or entity
	 * on the Internet. UUI is either guaranteed to be different or, is at least,
	 *  extremely likely to be different from any other UUId generated
	 */
	public String generateUUID(){
		String returnValue = UUID.randomUUID().toString().replaceAll("-", "");
		return returnValue;
	}
	
	private String generateRandomString(int length){
		StringBuilder returnValue = new StringBuilder(length);
		for(int i = 0; i <length;i++){
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		
		return new String(returnValue);
	}
	
	public String generateUserId(int length){
		return generateRandomString(length);
	}
	
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
