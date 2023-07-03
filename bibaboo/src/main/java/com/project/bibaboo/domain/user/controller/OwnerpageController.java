package com.project.bibaboo.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner/owner-page")
public class OwnerpageController {

  @GetMapping
  //@PreAuthorize("hasRole('OWNER')") // - security-context.xml에서 intercept-url 로 처리 
  public String ownerpage() {
    
    return "owner/owner-page-main";
  }
  
  @GetMapping("/alterations-register-page")
  public String getAlterationsResigerPage() {
    
    return "owner/owner-alter-register";
  }
}
