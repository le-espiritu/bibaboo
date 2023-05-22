package com.project.bibaboo.domain.alterations.dto;

import java.util.List;

public class AlterationsWithPagingDTO {

  private List<AlterationsDTO> alterList;
  private PageDTO pageDTO;
  
  public List<AlterationsDTO> getAlterList() {
    return alterList;
  }
  public void setAlterList(List<AlterationsDTO> alterList) {
    this.alterList = alterList;
  }
  public PageDTO getPageDTO() {
    return pageDTO;
  }
  public void setPageDTO(PageDTO pageDTO) {
    this.pageDTO = pageDTO;
  }
  
  @Override
  public String toString() {
    return "AlterationsWithPagingDTO [alterList=" + alterList + ", pageDTO=" + pageDTO + "]";
  }
  
}
