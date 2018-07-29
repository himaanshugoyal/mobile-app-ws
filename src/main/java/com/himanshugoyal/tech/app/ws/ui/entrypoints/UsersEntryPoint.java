package com.himanshugoyal.tech.app.ws.ui.entrypoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;

import com.himanshugoyal.tech.app.ws.service.UsersService;
import com.himanshugoyal.tech.app.ws.service.impl.UsersServiceImpl;
import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;
import com.himanshugoyal.tech.app.ws.ui.model.request.CreateUserRequestModel;
import com.himanshugoyal.tech.app.ws.ui.model.response.UserProfileRest;

@Path("/users")
public class UsersEntryPoint {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public UserProfileRest createUser(CreateUserRequestModel requestObject){
		UserProfileRest returnValue = new UserProfileRest();
		
		//Prepare UserDTO
		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(requestObject, userDto);
		
		//Create New User
		UsersService userService = new UsersServiceImpl();
		UserDTO createdUserProfile = userService.createUser(userDto);
		
		//Prepare response
		BeanUtils.copyProperties(createdUserProfile, returnValue);
		return returnValue;
	}
	
	
	
}
