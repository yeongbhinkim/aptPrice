package com.ybkim.AptPrice.domain.MyHomePrice.svc;


import com.ybkim.AptPrice.domain.MyHomePrice.MyHomePrice;
import com.ybkim.AptPrice.domain.MyHomePrice.dao.MyHomePriceFilterCondition;

import java.util.List;

public interface MyHomePriceSVC {

    /**
     * APT 조건 조회
     * @param myHomePriceFilterCondition
     * @return
     */
    List<MyHomePrice> MyHomePriceList(MyHomePriceFilterCondition myHomePriceFilterCondition);

    //커피숍 개별 조회
    MyHomePrice findByCityId(Long cityId);

    int totalCount(MyHomePriceFilterCondition myHomePriceFilterCondition);

  }
