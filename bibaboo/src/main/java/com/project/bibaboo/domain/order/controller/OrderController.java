package com.project.bibaboo.domain.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.order.dto.OrderDTO;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderPageDTO;
import com.project.bibaboo.domain.order.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

  OrderService orderService;
  
  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService=orderService;
  }

  @GetMapping("/{userId}")
  public ModelAndView orderPage(@PathVariable(name = "userId") String userId, OrderPageDTO orderPageDTO) {
    
    List<OrderPageCategoryDTO> orderList = orderService.getGoodsInfoForOrder(orderPageDTO);
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("orderList", orderList);
    // 추후 userId에 해당하는 회원정보 불러오는 코드 추가
    
    mv.setViewName("order/order-page");
    
    return mv;
  }
  
  @PostMapping
  public void makeOrder(OrderDTO orderDTO) {
    System.out.println("orderDTO===============================================");
    System.out.println(orderDTO);
  }
}
