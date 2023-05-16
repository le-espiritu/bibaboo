package com.project.bibaboo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlTestController {

  @GetMapping("/alterList")
  public String list() {
    return "alter/alter-list";
  }

  @GetMapping("/alterDetail")
  public String detail() {
    return "alter/alter-detail";
  }

  @GetMapping("/areaTop5")
  public String areaTop5() {
    return "alter/area-top5";
  }

  @GetMapping("/top5")
  public String top5() {
    return "alter/whole-top5";
  }

  @GetMapping("/noResult")
  public String noResult() {
    return "error/no-result";
  }

  @GetMapping("/loginPage")
  public String loginPage() {
    return "member/login-page";
  }

  @GetMapping("/joinPage")
  public String joinPage() {
    return "member/join-page";
  }

  @GetMapping("/404")
  public String notFound() {
    return "error/404-custom";
  }

  @GetMapping("/register")
  public String register() {
    return "alter/alter-register";
  }

  @GetMapping("/order")
  public String order() {
    return "order/order-page";
  }

  @GetMapping("/adminPage")
  public String adminPage() {
    return "admin/admin-main";
  }

  @GetMapping("/adminRegister")
  public String adminRegister() {
    return "admin/admin-register";
  }

}
