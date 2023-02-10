package com.ybkim.AptPrice.domain.MyHomePrice.svc;


import com.ybkim.AptPrice.domain.MyHomePrice.MyHomePrice;
import com.ybkim.AptPrice.domain.MyHomePrice.dao.MyHomePriceFilterCondition;

import java.util.List;

public interface MyHomePriceSVC {

  /**
   * APT 조건 조회
   *
   * @param myHomePriceFilterCondition
   * @return
   */
  List<MyHomePrice> MyHomePriceList(MyHomePriceFilterCondition myHomePriceFilterCondition);

  /**
   * 전체건수
   *
   * @param myHomePriceFilterCondition
   * @return
   */
  int totalCount(MyHomePriceFilterCondition myHomePriceFilterCondition);


  /**
   * APT 상세조회
   *
   * @param myHomePriceFilterCondition
   * @return
   */
  MyHomePrice MyHomePriceDetail(MyHomePriceFilterCondition myHomePriceFilterCondition);

}
