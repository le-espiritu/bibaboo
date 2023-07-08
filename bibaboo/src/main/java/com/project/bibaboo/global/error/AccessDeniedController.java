package com.project.bibaboo.global.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

  @GetMapping("/authDenied")
  public String accessDeniedHandler() {
    
    return "error/auth-denied";
  }
}
