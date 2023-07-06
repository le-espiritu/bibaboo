package com.project.bibaboo.domain.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.Categories;
import com.project.bibaboo.domain.alterations.service.AlterationsCategoryService;
import com.project.bibaboo.domain.alterations.service.AlterationsService;
import com.project.bibaboo.domain.order.dto.OrderCategoryAndPageDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrdererInfoDTO;
import com.project.bibaboo.domain.order.service.OrderService;

@Controller
@RequestMapping("/owner/owner-page")
public class OwnerpageController {

  AlterationsService alterationsService;
  AlterationsCategoryService categoryService;
  OrderService orderService;

  @Autowired
  public OwnerpageController(AlterationsCategoryService categoryService,
      AlterationsService alterationsService, OrderService orderService) {
    this.categoryService = categoryService;
    this.alterationsService = alterationsService;
    this.orderService = orderService;
  }

  @GetMapping
  // @PreAuthorize("hasRole('OWNER')") // - security-context.xml에서 intercept-url 로 처리
  public String ownerpage() {

    return "owner/owner-page-main";
  }

  @GetMapping("/info")
  public ModelAndView getAlterInfo(int alterId) {

    AlterationsDTO alterationsDTO = alterationsService.selectById(alterId);

    ModelAndView mv = new ModelAndView();
    mv.addObject("alterationsDTO", alterationsDTO);
    mv.setViewName("owner/owner-info-page");

    return mv;
  }

  @GetMapping("/alterations-register-page")
  public String getAlterationsResigerPage() {

    return "owner/owner-alter-register";
  }

  @GetMapping("/category-register-page")
  public ModelAndView getCategoryRegister(int alterId) {

    // Categories categories = categoryService.getCategoriesByUserId(userId);
    Categories categories = categoryService.getCategories(alterId);

    ModelAndView mv = new ModelAndView();
    mv.addObject("categories", categories);
    mv.setViewName("owner/owner-category-register");

    return mv;
  }

  @GetMapping("/order-list")
  public ModelAndView getOrderListPage(int alterId) {
    
    OrderCategoryAndPageDTO orderCategoryAndPageDTO = orderService.getCategoriesAndUserInfoByAlterId(alterId);

    ModelAndView mv = new ModelAndView();
    mv.addObject("orderCategoryAndPageDTO", orderCategoryAndPageDTO);
    mv.setViewName("owner/owner-order-list");

    return mv;
  }
  
  @PostMapping("/user-info-popup")
  public String getUserInfoPopup(OrdererInfoDTO ordererInfoDTO, ModelMap model) {
    model.addAttribute("ordererInfoDTO", ordererInfoDTO);
    
    return"user-info-popup";
  }
}
