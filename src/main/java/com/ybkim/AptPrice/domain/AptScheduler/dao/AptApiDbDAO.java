package com.ybkim.AptPrice.domain.AptScheduler.dao;


import com.ybkim.AptPrice.domain.AptScheduler.AptApiDb;

import java.util.List;

public interface AptApiDbDAO {


  /**
   * API -> DB insert
   *
   * @return
   */
  void insertApiDb(List<AptApiDb> aptApiDb);

}
