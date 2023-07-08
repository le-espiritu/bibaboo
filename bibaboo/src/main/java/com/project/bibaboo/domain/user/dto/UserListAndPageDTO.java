package com.project.bibaboo.domain.user.dto;

import java.util.List;
import com.project.bibaboo.global.common.dto.PageDTO;

public class UserListAndPageDTO {
  private List<UserDTO> userList;
  private PageDTO pageDTO;
  public List<UserDTO> getUserList() {
    return userList;
  }
  public void setUserList(List<UserDTO> userList) {
    this.userList = userList;
  }
  public PageDTO getPageDTO() {
    return pageDTO;
  }
  public void setPageDTO(PageDTO pageDTO) {
    this.pageDTO = pageDTO;
  }
  
  @Override
  public String toString() {
    return "UserListAndPageDTO [userList=" + userList + ", pageDTO=" + pageDTO + "]";
  }
  
}
