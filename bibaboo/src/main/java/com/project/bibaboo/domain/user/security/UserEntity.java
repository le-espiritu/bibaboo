package com.project.bibaboo.domain.user.security;

// 로그인 아이디와 암호 정보를 가지고 있는 객체
public class UserEntity {

  private String loginUserEmail;
  private String password;

  public UserEntity(String loginUserEmail, String password) {
    this.loginUserEmail = loginUserEmail;
    this.password = password;
  }

  public String getLoginUserEmail() {
    return loginUserEmail;
  }

  public void setLoginUserEmail(String loginUserEmail) {
    this.loginUserEmail = loginUserEmail;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
