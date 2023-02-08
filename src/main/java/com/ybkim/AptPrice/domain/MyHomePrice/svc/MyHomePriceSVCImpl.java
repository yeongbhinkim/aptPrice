package com.ybkim.AptPrice.domain.MyHomePrice.svc;


import com.ybkim.AptPrice.domain.MyHomePrice.MyHomePrice;
import com.ybkim.AptPrice.domain.MyHomePrice.dao.MyHomePriceDAO;
import com.ybkim.AptPrice.domain.MyHomePrice.dao.MyHomePriceFilterCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MyHomePriceSVCImpl implements MyHomePriceSVC {

  private final MyHomePriceDAO MyHomePriceDAO;

  private String CODE = "F0101";

  /**
   * APT 조건 조회
   *
   * @param myHomePriceFilterCondition
   * @return
   */
  @Override
  public List<MyHomePrice> MyHomePriceList(MyHomePriceFilterCondition myHomePriceFilterCondition) {
    return MyHomePriceDAO.selectMyHomePriceList(myHomePriceFilterCondition);
  }


  //상세조회
  @Override
  public MyHomePrice findByCityId(Long cityId) {
    MyHomePrice findedItem = MyHomePriceDAO.selectOne(cityId);
    return findedItem;
  }

  /**
   * 전체 건수
   * @return
   */
  @Override
  public int totalCount(MyHomePriceFilterCondition myHomePriceFilterCondition) {return MyHomePriceDAO.totalCount(myHomePriceFilterCondition);}

}
