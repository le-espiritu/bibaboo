package com.project.bibaboo.domain.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.order.dao.OrderDao;
import com.project.bibaboo.domain.order.dto.OrderCancleDTO;
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
    this.orderService = orderService;
  }

  @GetMapping("/{userId}")
  public ModelAndView orderPage(@PathVariable(name = "userId") String userId,
      OrderPageDTO orderPageDTO) {

    List<OrderPageCategoryDTO> orderList = orderService.getGoodsInfoForOrder(orderPageDTO);

    ModelAndView mv = new ModelAndView();
    mv.addObject("orderList", orderList);
    // 추후 userId에 해당하는 회원정보 불러오는 코드 추가

    mv.setViewName("order/order-page");

    return mv;
  }

  @PostMapping
  public String makeOrder(OrderDTO orderDTO) {

    // 유저 id 또는 주문자 정보 세팅 => 추후 프론트에서 값을 넘겨주는 것으로 변경
    orderDTO.setUserId(1);
    orderDTO.setUserEmail("bibaboo@bibaboo.com");
    orderDTO.setUserName("홍길동");
    orderDTO.setUserPhoneNumber("010-1234-1234");

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
}
