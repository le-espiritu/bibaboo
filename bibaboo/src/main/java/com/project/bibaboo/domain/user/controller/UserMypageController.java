package com.project.bibaboo.domain.user.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.order.dto.OrderCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderListAndPageDTO;
import com.project.bibaboo.domain.order.service.OrderService;
import com.project.bibaboo.domain.user.dto.UserDTO;
import com.project.bibaboo.domain.user.service.UserService;
import com.project.bibaboo.global.common.dto.Criteria;

@Controller
@RequestMapping("/user/mypage")
public class UserMypageController {

  UserService userService;
  OrderService orderService;

  @Autowired
  public UserMypageController(OrderService orderService, UserService userService) {
    this.orderService = orderService;
    this.userService = userService;
  }

  @GetMapping
  public String userMypageView() {
    return "user/user-page-main";
  }
  
  @GetMapping("/info")
  public ModelAndView getMyInfo(Principal principal) {
    String loginEmail = principal.getName();
    UserDTO userInfo = userService.getUserByEmail(loginEmail);
    ModelAndView mv = new ModelAndView();
    mv.addObject("userInfo", userInfo);
    mv.setViewName("user/user-my-info");
    
    return mv;
  }

  @GetMapping("/order-list")
  public ModelAndView getOrderListByUser(@ModelAttribute Criteria criteria) {

    OrderListAndPageDTO orderListAndPageDTO = orderService.getOrderList(criteria);

    ModelAndView mv = new ModelAndView();
    mv.addObject("orderListAndPageDTO", orderListAndPageDTO);
    mv.setViewName("user/user-order-list");

    return mv;
  }

  @GetMapping("/order-list/{orderId}")
  public ModelAndView getOrderCategoryDetail(@PathVariable(name = "orderId") int orderId) {

    List<OrderCategoryDTO> orderCategoryList = orderService.getOrderCategories(orderId);

    ModelAndView mv = new ModelAndView();
    mv.addObject("orderCategoryList", orderCategoryList);
    mv.setViewName("user/user-order-detail");

    return mv;
  }

  @PostMapping("/review-writer-page")
  public ModelAndView orderReviewWriterVeiw(@ModelAttribute OrderCategoryDTO orderCategoryDTO) {

    ModelAndView mv = new ModelAndView();
    mv.addObject("orderCategoryDTO", orderCategoryDTO);
    mv.setViewName("user/user-order-review-writer");
    
    return mv;
  }
}
