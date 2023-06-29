package com.project.bibaboo.domain.user.dto;

public class UserRoleDTO {

  private Integer id;
  private Integer userId;
  private String roleName;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  public String getRoleName() {
    return roleName;
  }
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
  
  @Override
  public String toString() {
    return "UserRoleDTO [id=" + id + ", userId=" + userId + ", roleName=" + roleName + "]";
  }
  
}
