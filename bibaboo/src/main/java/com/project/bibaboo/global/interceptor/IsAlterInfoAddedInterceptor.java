package com.project.bibaboo.global.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.project.bibaboo.domain.user.exception.AlterInfoIsNullException;

public class IsAlterInfoAddedInterceptor extends HandlerInterceptorAdapter {

  private static final Logger logger = LoggerFactory.getLogger(IsAlterInfoAddedInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    logger.info("prehandle = {} 를 호출했습니다.", handler);

    String alterId = request.getParameter("alterId");
    if (alterId == null || alterId.isEmpty() || alterId.equals("null")) {
      // return false;
      throw new AlterInfoIsNullException("아직 수선집이 등록되지 않았습니다.");
    }

    return true;
  }

}
