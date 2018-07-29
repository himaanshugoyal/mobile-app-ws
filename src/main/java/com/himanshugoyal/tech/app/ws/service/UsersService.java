package com.himanshugoyal.tech.app.ws.service;

import com.himanshugoyal.tech.app.ws.shared.dto.UserDTO;

public interface UsersService {

 UserDTO createUser(UserDTO user);

 UserDTO getUser(String id);
}
