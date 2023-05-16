package com.project.bibaboo.domain.alterations.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;

@RestController
@RequestMapping("/alterations")
public class AlterationsController {

  @PostMapping
  public void register(@ModelAttribute AlterationsDto dto) {
    System.out.println(dto);
  }
  
}
