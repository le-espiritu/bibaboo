package com.project.bibaboo.domain.user.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

  private String username;
  private String password;
  private boolean isEnabled;
  private boolean isAccountNonExpired;
  private boolean isAccountNonLocked;
  private boolean isCredentialsNonExpired;
  private Collection<? extends GrantedAuthority> authorities;

  private Integer userId;
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }
  
  public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
    this.authorities=authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password=password;
  }

  @Override
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username=username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return isAccountNonExpired;
  }
  
  public void setAccountNonExpired(boolean accountNonExpired) {
    this.isAccountNonExpired=accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return isAccountNonLocked;
  }
  
  public void setAccountNonLocked(boolean accountNonLocked) {
    this.isAccountNonLocked = accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return isCredentialsNonExpired;
  }
  
  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.isCredentialsNonExpired=credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return isEnabled;
  }
  
  public void setEnabled(boolean enabled) {
    this.isEnabled=enabled;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  
}
