package com.project.bibaboo.domain.alterations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.alterations.dto.Categories;
import com.project.bibaboo.domain.alterations.service.AlterationsCategoryService;

@Controller
@RequestMapping("/alterations/{alterId}/category")
public class AlterationsCategoryController {
  
  AlterationsCategoryService alterationsCategoryService;
  
  @Autowired
  public AlterationsCategoryController(AlterationsCategoryService alterationsCategoryService) {
    this.alterationsCategoryService = alterationsCategoryService;
  }
  
  @GetMapping
  public ModelAndView getCategoryView(@PathVariable(name="alterId") int alterId) {
    Categories categories = alterationsCategoryService.getCategories(alterId);
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("categories", categories);
    mv.setViewName("alter/alter-category");
    return mv;
  }

  @PostMapping
  public String registerCategory(Categories categories) {
    
    alterationsCategoryService.registerCategory(categories);
    
    return"redirect:/";
  }
  
}
