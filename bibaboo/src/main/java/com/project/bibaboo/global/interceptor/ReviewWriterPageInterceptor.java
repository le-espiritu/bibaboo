package com.project.bibaboo.global.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.project.bibaboo.domain.order.exception.OrderStateIsNotCompletedException;
import com.project.bibaboo.domain.order.service.OrderService;

public class ReviewWriterPageInterceptor extends HandlerInterceptorAdapter {

  private static final Logger logger = LoggerFactory.getLogger(ReviewWriterPageInterceptor.class);
  
  @Autowired
  OrderService orderService;
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    
    logger.info("prehandle = {}를 호출했습니다.", handler);
    String orCaId = request.getParameter("orderCategoryId");
    int orderCategoryId = Integer.parseInt(orCaId);
    String orderState = orderService.orderCategoryStateCheckForReview(orderCategoryId);
    
    if(!orderState.equals("수선완료")) {
      throw new OrderStateIsNotCompletedException("수선완료 상태에서 리뷰를 작성할 수 있습니다. 주문 상태가 수선완료가 아닙니다.");
    }
    
    return true;
  }
}
