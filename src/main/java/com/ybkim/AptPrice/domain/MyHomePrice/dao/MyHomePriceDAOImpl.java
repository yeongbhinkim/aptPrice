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

    sql.append(" SELECT A.* ");
    sql.append("  ,GET_AMOUNT(A.CITY,A.STREET,A.BON_BUN,A.BU_BUN,A.DAN_GI_MYEONG,A.SQUARE_METER,A.LAYER,A.CONSTRUCTION_DATE) AS AMOUNTLIST ");
    sql.append("  ,GET_CONTRACT(A.CITY,A.STREET,A.BON_BUN,A.BU_BUN,A.DAN_GI_MYEONG,A.SQUARE_METER,A.LAYER,A.CONSTRUCTION_DATE) AS CONTRACT ");
    sql.append("  FROM( ");
//    sql.append("   SELECT ROW_NUMBER() OVER (ORDER BY CONTRACT_DATE DESC, LPAD(CONTRACT_DAY, 2, '0') DESC) NO, a.* FROM APT A ");
    sql.append("   SELECT ROW_NUMBER() OVER (ORDER BY CONTRACT_DATE DESC, LPAD(CONTRACT_DAY, 2, '0') DESC) NO ");
    sql.append("  ,ROW_NUMBER() OVER (PARTITION BY A.CITY ,A.STREET ,A.BON_BUN ,A.BU_BUN ,A.DAN_GI_MYEONG ,A.SQUARE_METER ,A.LAYER ,A.CONSTRUCTION_DATE ORDER BY A.CONTRACT_DATE DESC) AS RN  ");
    sql.append("  ,A.* FROM APT A ");
    sql.append("   WHERE 1 = 1");
    sql.append("   AND CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0') BETWEEN REPLACE(?,'-','') AND REPLACE(?,'-','') ");
    sql.append("   AND CITY  LIKE '%'||REPLACE(?,'전체','')||'%'||'%'||REPLACE(?,'전체','')||'%'||'%'||REPLACE(?,'전체','')||'%' ");
//    sql.append("   AND DAN_GI_MYEONG LIKE '%'||?||'%'");
//    sql.append("   AND ROAD_NAME LIKE '%'||?||'%'");
    sql.append("   AND TO_NUMBER(SUBSTR(SQUARE_METER, 1, INSTR(SQUARE_METER, '.') - 1))  BETWEEN  TO_NUMBER(?)  AND  TO_NUMBER(?)");
    sql.append("   AND  TO_NUMBER(REPLACE(AMOUNT, ',')) BETWEEN  TO_NUMBER(REPLACE(?, ','))  AND  TO_NUMBER(REPLACE(?, ','))");
    sql.append("   ORDER BY CONTRACT_DATE DESC, LPAD(CONTRACT_DAY, 2, '0') DESC ");
    sql.append(" ) A ");
    sql.append(" WHERE A.NO BETWEEN ? AND ? ");
    sql.append(" AND A.RN= 1 ");

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

    sql.append(" SELECT count(*) FROM( ");
    sql.append("   SELECT ");
    sql.append("   ROW_NUMBER() OVER (PARTITION BY A.CITY ,A.STREET ,A.BON_BUN ,A.BU_BUN ,A.DAN_GI_MYEONG ,A.SQUARE_METER ,A.LAYER ,A.CONSTRUCTION_DATE ORDER BY A.CONTRACT_DATE DESC) AS RN  ");
    sql.append("   FROM APT A ");
    sql.append("   WHERE 1 = 1");
    sql.append("   AND CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0') BETWEEN REPLACE(?,'-','') AND REPLACE(?,'-','') ");
    sql.append("   AND CITY  LIKE '%'||REPLACE(?,'전체','')||'%'||'%'||REPLACE(?,'전체','')||'%'||'%'||REPLACE(?,'전체','')||'%' ");
    sql.append("   AND TO_NUMBER(REPLACE(SQUARE_METER, '.')) BETWEEN  TO_NUMBER(?)  AND  TO_NUMBER(?)");
    sql.append("   AND  TO_NUMBER(REPLACE(AMOUNT, ',')) BETWEEN  TO_NUMBER(REPLACE(?, ','))  AND  TO_NUMBER(REPLACE(?, ','))");
    sql.append(" ) A ");
    sql.append(" WHERE A.RN= 1 ");

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

  /**
   * APT 상세조회
   *
   * @param myHomePriceFilterCondition
   * @return
   */
  @Override
  public MyHomePrice selectMyHomePriceDetail(MyHomePriceFilterCondition myHomePriceFilterCondition) {

    StringBuffer sql = new StringBuffer();
    sql.append("  ");

    MyHomePrice MyHomePriceItem = null;
    try {
      MyHomePriceItem = jdbcTemplate.queryForObject(
          sql.toString(),
          new BeanPropertyRowMapper<>(MyHomePrice.class)
      );
    } catch (Exception e) { //1건을 못찾으면
      MyHomePriceItem = null;
    }

    return MyHomePriceItem;
  }

}