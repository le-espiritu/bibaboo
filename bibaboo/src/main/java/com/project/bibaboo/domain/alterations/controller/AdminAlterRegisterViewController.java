package com.project.bibaboo.domain.alterations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminAlterRegisterViewController {

  @GetMapping("/admin/register")
  public String adminRegisterView() {
    return "admin/admin-register";
  }

}
