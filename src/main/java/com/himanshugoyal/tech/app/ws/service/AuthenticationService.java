package com.himanshugoyal.tech.app.ws.service;

import com.himanshugoyal.tech.app.ws.exceptions.AuthenticationException;
import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;

public interface AuthenticationService {
	UserDTO authenticate (String userName, String password) throws AuthenticationException;
}
