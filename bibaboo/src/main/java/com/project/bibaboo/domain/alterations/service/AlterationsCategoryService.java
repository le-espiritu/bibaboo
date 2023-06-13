package com.project.bibaboo.domain.alterations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.bibaboo.domain.alterations.dao.AlterationsCategoryDao;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.Categories;

@Service
public class AlterationsCategoryService {
  AlterationsCategoryDao alterationsCategoryDao;
  
  @Autowired
  public AlterationsCategoryService(AlterationsCategoryDao alterationsCategoryDao) {
    this.alterationsCategoryDao = alterationsCategoryDao;
  }
  
  public void registerCategory(Categories categories) {
    alterationsCategoryDao.registerCategory(categories);
  }
  
  public Categories getCategories(int alterId) {
    Categories categories = new Categories();
    categories.setCategoryList(alterationsCategoryDao.getCategories(alterId));
    
    return categories;
  }
}
