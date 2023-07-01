package com.project.bibaboo.domain.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/owner/owner-page")
public class OwnerpageController {

  @GetMapping
  @PreAuthorize("hasRole('OWNER')")
  public String ownerpage() {
    
    return "owner/owner-page-main";
  }
}
