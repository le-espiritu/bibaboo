package com.project.bibaboo.domain.user.security;

//로그인 아이디와 권한 정보를 가지고 있는 클래스
public class UserRoleEntity {

  private String loginUserEmail;
  private String roleName;
  
  public UserRoleEntity(String loginUserEmail, String roleName) {
    this.loginUserEmail=loginUserEmail;
    this.roleName=roleName;
  }

  public String getLoginUserEmail() {
    return loginUserEmail;
  }

  public void setLoginUserEmail(String loginUserEmail) {
    this.loginUserEmail = loginUserEmail;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
  
}
