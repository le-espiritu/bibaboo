package com.project.bibaboo.domain.user.security;

import java.util.List;
import com.project.bibaboo.domain.user.dto.UserDTO;

public interface UserDbService {
  public UserEntity getUser(String loginUserEmail);
  public UserDTO getUserAndAlterId(String loginUserEmail);
  public List<UserRoleEntity> getUserRoles(String loginUserEmail);
}

/*
 * 로그인 정보가 저장된 데이터베이스의 구조는 프로젝트마다 다르기 때문에 스프링 시큐리티에서 알 수가 없다.
 * 로그인 정보가 어디에 저장되어 있든 해당 인터페이스를 구현하는 쪽에 맡기게 된다는 것을 의미한다.
 */
