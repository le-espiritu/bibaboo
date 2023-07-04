package com.project.bibaboo.domain.user.security;

import java.util.Date;

// 로그인 아이디와 암호 정보를 가지고 있는 객체
public class UserEntity {

  private Integer id;
  private String email;
  private String password;
  private String name;
  private String phoneNumber;
  private Date createDate;
  private int enable;
  
  public UserEntity(Integer id, String email, String password, String name, String phoneNumber,
      Date createDate, int enable) {
    super();
    this.id = id;
    this.email = email;
    this.password = password;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.createDate = createDate;
    this.enable = enable;
  }

  public Integer getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public int getEnable() {
    return enable;
  }

}
