package com.project.bibaboo.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginAndJoinViewController {

  @GetMapping("/login-page")
  public String loginPage() {
    return "login/login-page";
  }
  
  //@PreAuthorize("isAnonymous()") PreAuthorixe와 isAnonymous(), permitAll()은 같이 사용할 수 없음
  @GetMapping("/user-join-page")
  public String userJoinPage() {
    return"login/join-page";
  }
  
  @GetMapping("/owner-join-page")
  public String ownerJoinPage() {
    return"login/owner-join-page";
  }
}
