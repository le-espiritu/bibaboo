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
import com.project.bibaboo.domain.alterations.dto.Criteria;
import com.project.bibaboo.domain.alterations.service.AlterationsService;

@Controller
@RequestMapping("/admin/alterations")
public class AdminAlterationsController {

  AlterationsService alterationsService;

  @Autowired
  public AdminAlterationsController(AlterationsService alterationsService) {
    this.alterationsService = alterationsService;
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
  public ModelAndView adminUpdateView(@PathVariable(name="id")int id) {
    
    AlterationsDTO alterInfo = alterationsService.selectById(id);
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("alterInfo", alterInfo);
    mv.setViewName("admin/admin-alter-update");
    
    return mv;
  }
  
  @GetMapping("/{id}/category-register-view")
  public ModelAndView adminCategoryRegisterView(@PathVariable(name="id")int id) {
    AlterationsDTO alterationsDTO = new AlterationsDTO();
    alterationsDTO.setId(id);
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("alterationsDTO", alterationsDTO);
    mv.setViewName("admin/admin-category-register");
    
    return mv;
  }

  @DeleteMapping("/{id}")
  public String deleteAlterations(@PathVariable(name = "id") int id) {
    alterationsService.delete(id);
    return "redirect:/admin/alterations";
  }

}
