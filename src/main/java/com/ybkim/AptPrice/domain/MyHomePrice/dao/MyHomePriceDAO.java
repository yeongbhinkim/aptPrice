package com.ybkim.AptPrice.domain.MyHomePrice.dao;


import com.ybkim.AptPrice.domain.MyHomePrice.MyHomePrice;

import java.util.List;

public interface MyHomePriceDAO {

  /**
   * APT 조건 조회
   * @param myHomePriceFilterCondition
   * @return
   */
  List<MyHomePrice> selectMyHomePriceList(MyHomePriceFilterCondition myHomePriceFilterCondition);

  //개별 조회
  MyHomePrice selectOne(Long cityId);

  //전체건수
  int totalCount(MyHomePriceFilterCondition myHomePriceFilterCondition);

}
