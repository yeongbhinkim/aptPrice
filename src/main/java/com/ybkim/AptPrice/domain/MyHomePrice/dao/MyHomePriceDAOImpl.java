package com.ybkim.AptPrice.domain.MyHomePrice.dao;


import com.ybkim.AptPrice.domain.MyHomePrice.MyHomePrice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor

public class MyHomePriceDAOImpl implements MyHomePriceDAO {

  private final JdbcTemplate jdbcTemplate;

  /**
   * APT 조건조회
   *
   * @param myHomePriceFilterCondition
   * @return
   */
  @Override
  public List<MyHomePrice> selectMyHomePriceList(MyHomePriceFilterCondition myHomePriceFilterCondition) {
    StringBuffer sql = new StringBuffer();


    sql.append(" SELECT A.* FROM( ");
    sql.append("   SELECT ROW_NUMBER() OVER (ORDER BY CONTRACT_DATE DESC, LPAD(CONTRACT_DAY, 2, '0') DESC) NO, a.* FROM APT A ");
    sql.append("   WHERE 1 = 1");
    sql.append("   AND CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0') BETWEEN REPLACE(?,'-','') AND REPLACE(?,'-','') ");
    sql.append("   AND CITY  LIKE '%'||REPLACE(?,'전체','')||'%'||'%'||REPLACE(?,'전체','')||'%'||'%'||REPLACE(?,'전체','')||'%' ");
//    sql.append("   AND DAN_GI_MYEONG LIKE '%'||?||'%'");
//    sql.append("   AND ROAD_NAME LIKE '%'||?||'%'");
    sql.append("   AND TO_NUMBER(REPLACE(SQUARE_METER, '.')) BETWEEN  TO_NUMBER(?)  AND  TO_NUMBER(?)");
    sql.append("   AND  TO_NUMBER(REPLACE(AMOUNT, ',')) BETWEEN  TO_NUMBER(REPLACE(?, ','))  AND  TO_NUMBER(REPLACE(?, ','))");
    sql.append("   ORDER BY CONTRACT_DATE DESC, LPAD(CONTRACT_DAY, 2, '0') DESC ");
    sql.append(" ) A ");
    sql.append(" WHERE A.NO BETWEEN ? AND ? ");

    List<MyHomePrice> list = jdbcTemplate.query(sql.toString(),
        new BeanPropertyRowMapper<>(MyHomePrice.class),
        myHomePriceFilterCondition.getContractDate(),
        myHomePriceFilterCondition.getContractDateTo(),
        myHomePriceFilterCondition.getSearchSidoCd(),
        myHomePriceFilterCondition.getSearchGugunCd(),
        myHomePriceFilterCondition.getSearchDongCd(),
//        myHomePriceFilterCondition.getSearchArea(),
        myHomePriceFilterCondition.getSearchAreaValue(),
        myHomePriceFilterCondition.getSearchAreaValueTo(),
        myHomePriceFilterCondition.getSearchFromAmount(),
        myHomePriceFilterCondition.getSearchToAmnount(),
        myHomePriceFilterCondition.getStartRec(),
        myHomePriceFilterCondition.getEndRec()
    );

    log.info("list123 = {}", list);

    return list;
  }

  /**
   * 전체건수
   *
   * @return
   */
  @Override
  public int totalCount(MyHomePriceFilterCondition myHomePriceFilterCondition) {

    StringBuffer sql = new StringBuffer();

    sql.append("   SELECT count(*) FROM APT ");
    sql.append("   WHERE 1 = 1");
    sql.append("   AND CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0') BETWEEN REPLACE(?,'-','') AND REPLACE(?,'-','') ");
    sql.append("   AND CITY  LIKE '%'||REPLACE(?,'전체','')||'%'||'%'||REPLACE(?,'전체','')||'%'||'%'||REPLACE(?,'전체','')||'%' ");
//    sql.append("   AND DAN_GI_MYEONG LIKE '%'||?||'%'");
//    sql.append("   AND ROAD_NAME LIKE '%'||?||'%'");
    sql.append("   AND TO_NUMBER(REPLACE(SQUARE_METER, '.')) BETWEEN  TO_NUMBER(?)  AND  TO_NUMBER(?)");
    sql.append("   AND  TO_NUMBER(REPLACE(AMOUNT, ',')) BETWEEN  TO_NUMBER(REPLACE(?, ','))  AND  TO_NUMBER(REPLACE(?, ','))");

    Integer cnt = 0;
    cnt = jdbcTemplate.queryForObject(
        sql.toString(), Integer.class,
        myHomePriceFilterCondition.getContractDate(),
        myHomePriceFilterCondition.getContractDateTo(),
        myHomePriceFilterCondition.getSearchSidoCd(),
        myHomePriceFilterCondition.getSearchGugunCd(),
        myHomePriceFilterCondition.getSearchDongCd(),
        myHomePriceFilterCondition.getSearchAreaValue(),
        myHomePriceFilterCondition.getSearchAreaValueTo(),
        myHomePriceFilterCondition.getSearchFromAmount(),
        myHomePriceFilterCondition.getSearchToAmnount()
    );
    log.info("cnt = {}", cnt);

    return cnt;
  }

  //조회
  @Override
  public MyHomePrice selectOne(Long cityId) {

    StringBuffer sql = new StringBuffer();
    sql.append(" SELECT ");
    sql.append("    city_id, ");
    sql.append("    city_name, ");
    sql.append("    city_address, ");
    sql.append("    city_tel, ");
    sql.append("    view_count, ");
    sql.append("    city_bookmark_count, ");
    sql.append("    city_review_count, ");
    sql.append("    parking, ");
    sql.append("    allday, ");
    sql.append("    city_cdate, ");
    sql.append("    bcategoryB0101, ");
    sql.append("    bcategoryB0102, ");
    sql.append("    bcategoryB0103, ");
    sql.append("    bcategoryB0104, ");
    sql.append("    bcategoryB0105,  ");
    sql.append("    hcategoryh0101,  ");
    sql.append("    hcategoryh0102,  ");
    sql.append("    hcategoryh0103,  ");
    sql.append("    hcategoryh0104  ");
    sql.append(" FROM ");
    sql.append("     city ");
    sql.append(" where city_id = ? ");

    MyHomePrice MyHomePriceItem = null;
    try {
      MyHomePriceItem = jdbcTemplate.queryForObject(
          sql.toString(),
          new BeanPropertyRowMapper<>(MyHomePrice.class),
          cityId);
    } catch (Exception e) { //1건을 못찾으면
      MyHomePriceItem = null;
    }

    return MyHomePriceItem;
  }

}