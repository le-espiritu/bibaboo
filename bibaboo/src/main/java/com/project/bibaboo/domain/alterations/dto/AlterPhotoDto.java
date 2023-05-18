package com.project.bibaboo.domain.alterations.dto;

public class AlterPhotoDto {

  private Integer id;
  private Integer alterId;
  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAlterId() {
    return alterId;
  }

  public void setAlterId(Integer alterId) {
    this.alterId = alterId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "AlterPhotoDto [id=" + id + ", alterId=" + alterId + ", name=" + name + "]";
  }

}
