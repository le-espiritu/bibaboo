package com.project.bibaboo.domain.alterations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsWithPagingDTO;
import com.project.bibaboo.domain.alterations.dto.Categories;
import com.project.bibaboo.global.common.dto.Criteria;
import com.project.bibaboo.domain.alterations.service.AlterationsCategoryService;
import com.project.bibaboo.domain.alterations.service.AlterationsService;

@Controller
@RequestMapping("/admin/alterations")
public class AdminAlterationsViewController {

  AlterationsService alterationsService;
  AlterationsCategoryService alterationsCategoryService;

  @Autowired
  public AdminAlterationsViewController(AlterationsService alterationsService,
      AlterationsCategoryService alterationsCategoryService) {
    
    this.alterationsService = alterationsService;
    this.alterationsCategoryService = alterationsCategoryService;
  }

  @GetMapping
  public ModelAndView adminAlterationsList(Criteria criteria) {

    AlterationsWithPagingDTO alterationsWithPagingDTO =
        alterationsService.getListWithPaging(criteria);

    ModelAndView mv = new ModelAndView();
    mv.addObject("alterationsWithPagingDTO", alterationsWithPagingDTO);
    mv.setViewName("admin/admin-alter-list");
    return mv;
  }

  @GetMapping("/register-view")
  public String adminRegisterView() {
    return "admin/admin-register";
  }

  @GetMapping("/{id}/update-view")
  public ModelAndView adminUpdateView(@PathVariable(name = "id") int id) {

    AlterationsDTO alterInfo = alterationsService.selectById(id);

    ModelAndView mv = new ModelAndView();
    mv.addObject("alterInfo", alterInfo);
    mv.setViewName("admin/admin-alter-update");

    return mv;
  }

  @GetMapping("/{id}/category-register-view")
  public ModelAndView adminCategoryRegisterView(@PathVariable(name = "id") int id) {
    AlterationsDTO alterationsDTO = new AlterationsDTO();
    alterationsDTO.setId(id);

    Categories categories = alterationsCategoryService.getCategories(id);

    ModelAndView mv = new ModelAndView();
    mv.addObject("alterationsDTO", alterationsDTO);
    mv.addObject("categories", categories);
    mv.setViewName("admin/admin-category-register");

    return mv;
  }

}
