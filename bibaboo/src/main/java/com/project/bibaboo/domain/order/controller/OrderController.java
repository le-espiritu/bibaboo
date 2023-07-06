package com.project.bibaboo.domain.order.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.order.dao.OrderDao;
import com.project.bibaboo.domain.order.dto.OrderCancleDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryStateDTO;
import com.project.bibaboo.domain.order.dto.OrderDTO;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderPageDTO;
import com.project.bibaboo.domain.order.service.OrderService;
import com.project.bibaboo.domain.user.dto.UserDTO;
import com.project.bibaboo.domain.user.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {

  OrderService orderService;
  UserService userService;

  @Autowired
  public OrderController(OrderService orderService, UserService userService) {
    this.orderService = orderService;
    this.userService = userService;
  }

  @GetMapping("/{userId}")
  public ModelAndView orderPage(@PathVariable(name = "userId") String userId,
      OrderPageDTO orderPageDTO, Principal principal) {

    List<OrderPageCategoryDTO> orderList = orderService.getGoodsInfoForOrder(orderPageDTO);
    UserDTO userDTO = userService.getUserByEmail(principal.getName());
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("orderList", orderList);
    mv.addObject("userInfo", userDTO);

    mv.setViewName("order/order-page");

    return mv;
  }

  @PostMapping
  public String makeOrder(OrderDTO orderDTO) {

    orderService.order(orderDTO);

    return "redirect:/";
  }

  @DeleteMapping
  public String orderCancle(OrderCancleDTO orderCancleDTO) {
    orderService.orderCancle(orderCancleDTO);
    
    //권한에 따라 return 달리 하기
    return "redirect:/users/" + orderCancleDTO.getUserId() + "/mypage/order-list?keyword="
        + orderCancleDTO.getKeyword() + "&amount=" + orderCancleDTO.getAmount() + "&pageNum="
        + orderCancleDTO.getPageNum();
  }
  
  @PutMapping("/state")
  public ResponseEntity<Object> updateState(@RequestBody OrderCategoryStateDTO orderCategoryStateDTO){
    orderService.updateOrderCategoryState(orderCategoryStateDTO);
    return ResponseEntity.ok().build();
  }
}
