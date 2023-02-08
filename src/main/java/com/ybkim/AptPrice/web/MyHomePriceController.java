package com.ybkim.AptPrice.web;


import com.ybkim.AptPrice.domain.MyHomePrice.MyHomePrice;
import com.ybkim.AptPrice.domain.MyHomePrice.dao.MyHomePriceFilterCondition;
import com.ybkim.AptPrice.domain.MyHomePrice.svc.MyHomePriceSVC;
import com.ybkim.AptPrice.domain.common.paging.FindCriteria;
import com.ybkim.AptPrice.web.form.MyHomePrice.MyHomePriceListForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/MyHomePrice")
@RequiredArgsConstructor
public class MyHomePriceController {
  private final MyHomePriceSVC MyHomePriceSVC;

  @Autowired
  @Qualifier("fc5") //동일한 타입의 객체가 여러개있을때 빈이름을 명시적으로 지정해서 주입받을때
  private FindCriteria fc;


  @GetMapping({"/list",
      "/list/{reqPage}",
      "/list/{reqPage}//",
      "/list/{reqPage}/{searchType}/{keyword}"})
  public String listAndReqPage(
      @PathVariable(required = false) Optional<Integer> reqPage,
      @PathVariable(required = false) Optional<String> searchType,
      @PathVariable(required = false) Optional<String> keyword,
      HttpServletRequest request, Model model) {
    log.info("/list 요청됨{},{},{}", reqPage, searchType, keyword);

    //FindCriteria 값 설정
    fc.getRc().setReqPage(reqPage.orElse(1)); //요청페이지, 요청없으면 1
    fc.setSearchType(searchType.orElse(""));  //검색유형
    fc.setKeyword(keyword.orElse(""));        //검색어


    List<MyHomePrice> list = null;

    MyHomePriceFilterCondition myHomePriceFilterCondition = new MyHomePriceFilterCondition(
            fc.getRc().getStartRec(), fc.getRc().getEndRec(),
            "searchType.get()", "keyword.get()");

    log.info("myHomePriceFilterCondition = ", myHomePriceFilterCondition);
    log.info("fc = ", fc);

    fc.setTotalRec(MyHomePriceSVC.totalCount(myHomePriceFilterCondition));
    fc.setSearchType(searchType.get());
    fc.setKeyword(keyword.get());
//    list = MyHomePriceSVC.MyHomePriceList(myHomePriceFilterCondition);

    List<MyHomePriceListForm> partOfList = new ArrayList<>();

    for (MyHomePrice MyHomePrice : list) {
      MyHomePriceListForm myHomePriceListForm = new MyHomePriceListForm();
      BeanUtils.copyProperties(MyHomePrice, myHomePriceListForm);
      partOfList.add(myHomePriceListForm);    }
    log.info("partOfList = ", partOfList);
    log.info("fc = ", fc);

    model.addAttribute("list", partOfList);
    model.addAttribute("fc", fc);

    log.info("list={}", list);


    HttpSession session = request.getSession(false);
    if (session != null) {
      return "mainAfterLogin";
    }
    return "mainBeforeLogin";
  }


  //조회
  @GetMapping("/detail/{cityId}")
  public String detail(@PathVariable Long cityId,
                       HttpServletRequest request,
                       Model model) {

    MyHomePrice MyHomePrice = MyHomePriceSVC.findByCityId(cityId);
//    MyHomePriceDetailForm MyHomePriceDetailForm = new MyHomePriceDetailForm();

//    BeanUtils.copyProperties(MyHomePrice, MyHomePriceDetailForm);

    HttpSession session = request.getSession(false);

    String view = null;
    view = (session == null) ? "contentBeforeLogin" : "contentAfterLogin";

    return view;
  }


}
