package com.ybkim.AptPrice.web;


import com.ybkim.AptPrice.domain.MyHomePrice.svc.MyHomePriceSVC;
import com.ybkim.AptPrice.domain.common.paging.FindCriteria;
import com.ybkim.AptPrice.domain.home.home;
import com.ybkim.AptPrice.domain.home.svc.homeSVC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

  private final MyHomePriceSVC MyHomePriceSVC;

  private final homeSVC homeSVC;

  @Autowired
  @Qualifier("fc5") //동일한 타입의 객체가 여러개있을때 빈이름을 명시적으로 지정해서 주입받을때
  private FindCriteria fc;

  @RequestMapping({"/"})
  public String home(
      @PathVariable(required = false) Optional<String> CITY_CODE,
      @PathVariable(required = false) Optional<String> COUNTY_CODE,
      Model model) {

    log.info("/home 요청됨 {}, {} ", CITY_CODE, COUNTY_CODE);

    List<home> regionCity = homeSVC.regionCity();
    List<home> regionCounty = homeSVC.regionCounty(CITY_CODE.orElse(""));
    List<home> regionDistricts = homeSVC.regionDistricts(COUNTY_CODE.orElse(""));

    model.addAttribute("regionCity", regionCity);
    model.addAttribute("regionCounty", regionCounty);
    model.addAttribute("regionDistricts", regionDistricts);

    log.info("regionCity={}", regionCity);
    log.info("regionCounty={}", regionCounty);
    log.info("regionDistricts={}", regionDistricts);

    return "homeView";
  }

}
