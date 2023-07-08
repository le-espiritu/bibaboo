package com.project.bibaboo.domain.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.user.dto.UserListAndPageDTO;
import com.project.bibaboo.domain.user.service.UserService;
import com.project.bibaboo.global.common.dto.Criteria;

@Controller
@RequestMapping("/admin")
public class AdminPageController {
  
  UserService userService;
  
  @Autowired
  public AdminPageController(UserService userService) {
    this.userService = userService;
  }
  
  @GetMapping
  public String adminPage() {
    return "admin/admin-main";
  }
  
  @GetMapping("/user-list")
  public ModelAndView userListPage(Criteria criteria) {
    UserListAndPageDTO userListAndPageDTO = userService.getAllUsers(criteria);
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("userListAndPageDTO", userListAndPageDTO);
    mv.setViewName("admin/admin-user-list");
    
    return mv;
  }
}
