package com.project.bibaboo.domain.alterations.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.Categories;
import com.project.bibaboo.domain.alterations.dto.CategoryDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AlterationsCategoryServiceTest {
  
  static Logger logger = LoggerFactory.getLogger(AlterationsCategoryServiceTest.class);
  
  @Autowired
  AlterationsCategoryService alterationsCategoryService;
  
  @Test
  public void getCategoriesTest() {
    AlterationsDTO alterationsDTO = new AlterationsDTO();
    alterationsDTO.setId(19);
    
    Categories categories = alterationsCategoryService.getCategories(alterationsDTO);
    
    for(CategoryDTO dto : categories.getCategoryList()) {
      logger.info(dto.toString());
    }
    
    Assert.assertNotNull(categories);
  }

}
