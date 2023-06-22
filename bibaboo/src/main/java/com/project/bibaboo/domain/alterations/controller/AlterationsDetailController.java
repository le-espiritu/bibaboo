package com.project.bibaboo.domain.alterations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.alterations.dto.AlterationsAndReviewsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.service.AlterationsService;
import com.project.bibaboo.global.common.dto.Criteria;

@Controller
public class AlterationsDetailController {
  
  AlterationsService alterationsService;
  
  @Autowired
  public AlterationsDetailController(AlterationsService alterationsService) {
    this.alterationsService = alterationsService;
  }

  @GetMapping("/alterations/{id}")
  public ModelAndView getAlterDetail(@PathVariable(name="id") int id) {
    AlterationsDTO alterationsDTO =  alterationsService.selectById(id);
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("alterationsDTO", alterationsDTO);
    mv.setViewName("alter/alter-detail");
    return mv;
  }
  
  @GetMapping("/alterations2/{id}")
  public ModelAndView getAlterDetail2(@PathVariable(name="id") int id, Criteria criteria) {
    AlterationsAndReviewsDTO alterationsAndReviewsDTO =  alterationsService.getAlterDetailAndReviews(id, criteria);
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("alterationsAndReviewsDTO", alterationsAndReviewsDTO);
    mv.setViewName("alter/alter-detail2");
    return mv;
  }
}
