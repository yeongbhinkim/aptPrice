package com.ybkim.AptPrice.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class MainController {

  @RequestMapping("/main")
  public String mains(HttpServletRequest request) {

    return "mainView";
  }
}
