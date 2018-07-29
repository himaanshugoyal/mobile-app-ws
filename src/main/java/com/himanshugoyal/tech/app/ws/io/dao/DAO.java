/**
 * 
 */
package com.himanshugoyal.tech.app.ws.io.dao;

import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;

/**
 * @author himanshugoyal
 *
 */
public interface DAO {
	void openConnection();
	UserDTO getUserByUserName(String userName);
	UserDTO saveUser(UserDTO user);
	UserDTO getUser(String id);
	void closeConnection();
	
}
