package com.project.bibaboo.domain.user.service;

import com.project.bibaboo.domain.user.dto.UserDTO;
import com.project.bibaboo.domain.user.dto.UserListAndPageDTO;
import com.project.bibaboo.domain.user.security.UserDbService;
import com.project.bibaboo.global.common.dto.Criteria;

public interface UserService extends UserDbService {
  public void addUser(UserDTO userDTO);
  public void addOwner(UserDTO userDTO);
  public UserDTO getUserByEmail(String loginEmail);
  public UserListAndPageDTO getAllUsers(Criteria criteria);
}
