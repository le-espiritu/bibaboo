package com.project.bibaboo.domain.alterations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.bibaboo.domain.alterations.dto.Categories;
import com.project.bibaboo.domain.alterations.service.AlterationsCategoryService;

@Controller
public class AlterationsCategoryController {
  
  AlterationsCategoryService alterationsCategoryService;
  
  public AlterationsCategoryController(AlterationsCategoryService alterationsCategoryService) {
    this.alterationsCategoryService = alterationsCategoryService;
  }

  @PostMapping("/alterations/{id}/category") 
  public String registerCategory(Categories categories) {
    
    System.out.println(categories);
    
    alterationsCategoryService.registerCategory(categories);
    
    return"redirect:/";
  }
  
}
