package com.project.bibaboo.domain.alterations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.bibaboo.domain.alterations.service.AlterationsCategoryService;

@Controller
@RequestMapping("/alterations")
public class AlterationsViewController {
  
  AlterationsCategoryService alterationsCategoryService;
  
  @Autowired
  public AlterationsViewController(AlterationsCategoryService alterationsCategoryService) {
    this.alterationsCategoryService = alterationsCategoryService;
  }
  
  @GetMapping("/{id}/categories")
  public String getCategoryView() {
    
    return"";
  }
}
