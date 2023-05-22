package com.project.bibaboo.domain.alterations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
    mv.addObject("alterList", alterationsWithPagingDTO);
    mv.setViewName("admin/admin-alter-list");
    return mv;
  }

  @GetMapping("/register")
  public String adminRegisterView() {
    return "admin/admin-register";
  }

  @DeleteMapping("/{id}")
  public String deleteAlterations(@PathVariable(name = "id") int id) {
    alterationsService.delete(id);
    return "redirect:/admin/alterations";
  }

}
