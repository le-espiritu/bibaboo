package com.project.bibaboo.domain.user.dao;

import com.project.bibaboo.domain.user.dto.UserDTO;

public interface UserDao {
  public UserDTO getUserByEmail(String loginUserEmail);
  public int addUser(UserDTO userDTO);
}
