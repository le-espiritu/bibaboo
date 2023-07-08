package com.project.bibaboo.domain.user.dto;

import java.sql.Date;

public class UserDTO {

  private Integer id;
  private String email;
  private String password;
  private String name;
  private String phoneNumber;
  private Date createDate;
  private Integer enable;
  
  private Integer alterId;
  
  public Integer getAlterId() {
    return alterId;
  }
  public void setAlterId(Integer alterId) {
    this.alterId = alterId;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public Integer getEnable() {
    return enable;
  }
  public void setEnable(Integer enable) {
    this.enable = enable;
  }
  
  
}
