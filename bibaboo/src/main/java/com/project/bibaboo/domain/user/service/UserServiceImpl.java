package com.project.bibaboo.domain.user.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.project.bibaboo.domain.user.dao.UserDao;
import com.project.bibaboo.domain.user.dao.UserRoleDao;
import com.project.bibaboo.domain.user.dto.UserDTO;
import com.project.bibaboo.domain.user.dto.UserRoleDTO;
import com.project.bibaboo.domain.user.security.UserEntity;
import com.project.bibaboo.domain.user.security.UserRoleEntity;

@Service
public class UserServiceImpl implements UserService {

  UserDao userDao;
  UserRoleDao userRoleDao;
  
  public UserServiceImpl(UserDao userDao, UserRoleDao userRoleDao) {
    this.userDao=userDao;
    this.userRoleDao = userRoleDao;
  }
  
  @Override
  public UserEntity getUser(String loginUserEmail) {
    UserDTO userDTO = userDao.getUserByEmail(loginUserEmail);
    return new UserEntity(userDTO.getEmail(), userDTO.getPassword());
  }

  @Override
  public List<UserRoleEntity> getUserRoles(String loginUserEmail) {
    List<UserRoleDTO> userRoles = userRoleDao.getUserRoleByEmail(loginUserEmail);
    
    List<UserRoleEntity> roleList = new ArrayList<>();
    for(UserRoleDTO userRole : userRoles) {
      roleList.add(new UserRoleEntity(loginUserEmail, userRole.getRoleName()));
    }
    return roleList;
  }

}
