package com.project.bibaboo.domain.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.order.dto.OrderCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderListAndPageDTO;
import com.project.bibaboo.domain.order.service.OrderService;
import com.project.bibaboo.global.common.dto.Criteria;

@Controller
@RequestMapping("/users/{userId}/mypage")
public class UserMypageViewController {

  OrderService orderService;

  @Autowired
  public UserMypageViewController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping
  public String userMypageView(@PathVariable(name = "userId") int userId, ModelMap model) {
    model.addAttribute("userId", userId);
    return "user/user-page-main";
  }

  @GetMapping("/order-list")
  public ModelAndView getOrderListByUser(@PathVariable(name = "userId") int userId,
      @ModelAttribute Criteria criteria) {

    criteria.setKeyword(userId + "");

    OrderListAndPageDTO orderListAndPageDTO = orderService.getOrderList(criteria);

    ModelAndView mv = new ModelAndView();
    mv.addObject("orderListAndPageDTO", orderListAndPageDTO);
    mv.setViewName("user/user-order-list");

    return mv;
  }

  @GetMapping("/order-list/{orderId}")
  public ModelAndView getOrderCategoryDetail(@PathVariable(name = "userId") int userId,
      @PathVariable(name = "orderId") int orderId) {

    List<OrderCategoryDTO> orderCategoryList = orderService.getOrderCategories(orderId);

    ModelAndView mv = new ModelAndView();
    mv.addObject("orderCategoryList", orderCategoryList);
    mv.addObject("userId", userId);
    mv.setViewName("user/user-order-detail");

    return mv;
  }

  @GetMapping("/review-writer-page")
  public ModelAndView orderReviewWriterVeiw(@PathVariable(name = "userId") int userId,
      @ModelAttribute OrderCategoryDTO orderCategoryDTO) {

    ModelAndView mv = new ModelAndView();
    mv.addObject("orderCategoryDTO", orderCategoryDTO);
    mv.setViewName("user/user-order-review-writer");
    
    return mv;
  }
}
