package com.ybkim.AptPrice.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class MainController {

  @RequestMapping("/main")
  public String mains(HttpServletRequest request) {

    log.info("info={}", "main()호출됨");


    String view = null;
    HttpSession session = request.getSession(false);
    view = (session == null) ? "mainBeforeLogin" : "mainAfterLogin";

    return view;
  }
}
