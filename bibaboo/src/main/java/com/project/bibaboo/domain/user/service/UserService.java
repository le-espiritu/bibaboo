package com.project.bibaboo.domain.user.service;

import com.project.bibaboo.domain.user.dto.UserDTO;
import com.project.bibaboo.domain.user.security.UserDbService;

public interface UserService extends UserDbService {
  public void addUser(UserDTO userDTO);
  public void addOwner(UserDTO userDTO);
}
