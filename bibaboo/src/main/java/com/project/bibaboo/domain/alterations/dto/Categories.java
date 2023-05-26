package com.project.bibaboo.domain.alterations.dto;

import java.util.List;

public class Categories {

  List<CategoryDTO> categoryList;

  public List<CategoryDTO> getCategoryList() {
    return categoryList;
  }

  public void setCategoryList(List<CategoryDTO> categoryList) {
    this.categoryList = categoryList;
  }

  @Override
  public String toString() {
    return "Categories [categoryList=" + categoryList + "]";
  }

}
