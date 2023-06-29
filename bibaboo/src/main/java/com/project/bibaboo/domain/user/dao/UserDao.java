package com.project.bibaboo.domain.user.dao;

import java.util.List;
import com.project.bibaboo.domain.user.dto.UserDTO;
import com.project.bibaboo.domain.user.dto.UserRoleDTO;

public interface UserDao {
  public UserDTO getUserByEmail(String loginUserEmail);
  
}
