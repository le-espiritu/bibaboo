package com.project.bibaboo.domain.alterations.dto;

import java.util.List;

public class AlterTop5DTO {

  String categoryName;
  String areaKeyword;
  
  List<AlterationsDTO> alterTop5List;
  
  public List<AlterationsDTO> getAlterTop5List() {
    return alterTop5List;
  }
  public void setAlterTop5List(List<AlterationsDTO> alterTop5List) {
    this.alterTop5List = alterTop5List;
  }
  public String getCategoryName() {
    return categoryName;
  }
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
  public String getAreaKeyword() {
    return areaKeyword;
  }
  public void setAreaKeyword(String areaKeyword) {
    this.areaKeyword = areaKeyword;
  }
  
  @Override
  public String toString() {
    return "AlterTop5DTO [categoryName=" + categoryName + ", areaKeyword=" + areaKeyword
        + ", alterTop5List=" + alterTop5List + "]";
  }
  
}
