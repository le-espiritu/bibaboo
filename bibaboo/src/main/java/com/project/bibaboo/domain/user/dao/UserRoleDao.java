package com.project.bibaboo.domain.user.dao;

import java.util.List;
import com.project.bibaboo.domain.user.dto.UserDTO;
import com.project.bibaboo.domain.user.dto.UserRoleDTO;

public interface UserRoleDao {
  public List<UserRoleDTO> getUserRoleByEmail(String loginUserEmail);
  public int addUserRole(UserDTO userDTO);
  public int addUserAndOwnerRole(UserDTO userDTO);
}
