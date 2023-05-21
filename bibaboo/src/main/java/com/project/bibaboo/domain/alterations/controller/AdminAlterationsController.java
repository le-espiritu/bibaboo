package com.project.bibaboo.domain.alterations.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;
import com.project.bibaboo.domain.alterations.service.AlterationsService;

@Controller
@RequestMapping("/admin/alterations")
public class AdminAlterationsController {
  
  AlterationsService alterationsService;
  
  @Autowired
  public AdminAlterationsController(AlterationsService alterationsService) {
    this.alterationsService=alterationsService;
  }

  @GetMapping
  @ResponseBody
  public List<AlterationsDto> adminAlterationsList() {
    
    return alterationsService.selectAll();
  }
  
  @GetMapping("/register")
  public String adminRegisterView() {
    return "admin/admin-register";
  }

}
