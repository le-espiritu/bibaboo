package com.project.bibaboo.domain.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.bibaboo.domain.user.dto.UserDTO;
import com.project.bibaboo.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
  
  UserService userService;
  PasswordEncoder passwordEncoder;
  
  @Autowired
  public UserController(UserService userService, PasswordEncoder passwordEncoder) {
    this.userService=userService;
    this.passwordEncoder=passwordEncoder;
  }
  
  @PostMapping
  public String addUser(UserDTO userDTO) {
    String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
    userDTO.setPassword(encodedPassword);
    userService.addUser(userDTO);
    return "redirect:/";
  }
  
  @PostMapping("/owner")
  public String addOwner(UserDTO userDTO) {
    String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
    userDTO.setPassword(encodedPassword);
    userService.addOwner(userDTO);
    return"redirect:/";
  }
  
  @GetMapping
  @PreAuthorize("hasRole('USER')")
  @ResponseBody
  public String authTest() {
    return"같은 URL 일지라도, USER 권한이 있어야 요청 할수 있음";
  }
}
