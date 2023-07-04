package com.project.bibaboo.domain.user.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.project.bibaboo.domain.user.dto.UserDTO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  UserDbService userDbService;
  
  @Autowired
  public CustomUserDetailsService(UserDbService userDbService) {
    this.userDbService = userDbService;
  }
  
  @Override
  public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
    
    //UserEntity customUser = userDbService.getUser(userEmail);
    UserDTO customUser = userDbService.getUserAndAlterId(userEmail);
    if(customUser == null) {
      throw new UsernameNotFoundException("사용자가 입력한 아이디에 해당하는 사용자를 찾을 수 없습니다.");
    }
    
    CustomUserDetails customUserDetails = new CustomUserDetails();
    
    customUserDetails.setUsername(customUser.getEmail());
    customUserDetails.setPassword(customUser.getPassword());
    customUserDetails.setUser(customUser);
    
    List<UserRoleEntity> customRoles = userDbService.getUserRoles(userEmail);
    // 로그인 한 사용자의 권한 정보를 GrantedAuthority를 구현하고 있는 SimpleGrantedAuthority객체에 담아
    // 리스트에 추가한다. MemberRole 이름은 "ROLE_"로 시작되야 한다.
    List<GrantedAuthority> authorities = new ArrayList<>();
    if(customRoles != null) {
      for(UserRoleEntity customRole : customRoles) {
        authorities.add(new SimpleGrantedAuthority(customRole.getRoleName()));
      }
    }
    customUserDetails.setAuthorities(authorities);
    
    customUserDetails.setEnabled(true);
    customUserDetails.setAccountNonExpired(true);
    customUserDetails.setAccountNonLocked(true);
    customUserDetails.setCredentialsNonExpired(true);
    
    return customUserDetails;
  }

}
