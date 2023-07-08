package com.project.bibaboo.domain.user.dao;

import java.util.List;
import com.project.bibaboo.domain.user.dto.UserDTO;
import com.project.bibaboo.global.common.dto.Criteria;

public interface UserDao {
  public List<UserDTO> getAllUsers(Criteria criteria);
  public UserDTO getUserByEmail(String loginUserEmail);
  public int addUser(UserDTO userDTO);
  public int countUsers(Criteria criteria);
}
