<!--
'*  파 일 명 : jsp/home/homeView.jsp
'*  기    능 : home
'*  작 성 자 : 김영빈
'*  비    고 : 2023.02.20 작성
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<main th:fragment="mainList">
  <div class="Apt-list-wrap">
    <div class="Apt-list-box">
      <ul class="Apts-box">

        <li class="Apt-each" th:each="item : ${list}">
          <div class="Apt-container">
            <div class="Apt-container-util Apt-each_img Apt-img-rd ">
              <canvas th:id="${'chart-' + item.apt_id + ' canvas'}" width="240" height="170"></canvas>
            </div>
            <div class="Apt-container-util Apt-each_title">
              <span>
                <a href="" th:href="@{/MyHomePrice/detail/{apt_id}(apt_id=${item.apt_id})}"
                   th:text="${item.dan_gi_myeong}+${item.layer}+ì¸µ">ìíí¸ì´ë¦</a>
              </span>
            </div>
            <div class="Apt-container-util Apt-each_hashtag">
              <ul>
                <li class="Apt-hashtag-rep rep1">
                  <div>
                    <span class="mainHashtag" th:text="${item.city}">ìì¹</span>
                    <br>
                    <span class="mainHashtag" th:text="${item.square_meter}">ì ì©ë©´ì (ã¡)</span>
                    <span class="mainHashtag" th:text="${item.amount}">ê±°ëê¸ì¡(ë§ì)</span>
                    <span class="mainHashtag" th:text="${item.construction_date}">ê±´ì¶ëë</span>
                  </div>
                </li>
                <br>

              </ul>
            </div>
          </div>
        </li>
      </ul>

    </div>
  </div>
  <div class="AptPrice-page page">
    <!--              ì´ì íì´ì§ ì ë³´-->
    <th:block th:if="${fc.prev}">
      <a class="AptPrice-page-item" href=""
         th:href="@{/MyHomePrice/list/1/{contractDate}/{contractDateTo}/{searchSidoCd}/{searchGugunCd}/{searchDongCd}/{searchArea}/{searchAreaValue}/{searchAreaValueTo}/{searchFromAmount}/{searchToAmnount}
        (contractDate=${fc.contractDate},contractDateTo=${fc.contractDateTo},searchSidoCd=${fc.searchSidoCd},searchGugunCd=${fc.searchGugunCd},searchDongCd=${fc.searchDongCd},searchArea=${fc.searchArea}
        ,searchAreaValue=${fc.searchAreaValue},searchAreaValueTo=${fc.searchAreaValueTo},searchFromAmount=${fc.searchFromAmount},searchToAmnount=${fc.searchToAmnount})}">
        <i class="fas fa-angle-double-left"></i>
      </a>
      <a class="AptPrice-page-item" href=""
         th:href="@{/MyHomePrice/list/{reqPage}/{contractDate}/{contractDateTo}/{searchSidoCd}/{searchGugunCd}/{searchDongCd}/{searchArea}/{searchAreaValue}/{searchAreaValueTo}/{searchFromAmount}/{searchToAmnount}
        (reqPage=${fc.startPage-1}, contractDate=${fc.contractDate},contractDateTo=${fc.contractDateTo},searchSidoCd=${fc.searchSidoCd},searchGugunCd=${fc.searchGugunCd},searchDongCd=${fc.searchDongCd},searchArea=${fc.searchArea}
        ,searchAreaValue=${fc.searchAreaValue},searchAreaValueTo=${fc.searchAreaValueTo},searchFromAmount=${fc.searchFromAmount},searchToAmnount=${fc.searchToAmnount})}">
        <i class="fas fa-angle-left"></i>
      </a>
    </th:block>
    <!--              íì´ì§íì-->
    <th:block th:each="pnum : ${#numbers.sequence(fc.startPage,fc.endPage)}">
      <th:block th:if="${pnum != 0}">
        <a class="AptPrice-page-item" th:classappend="${fc.rc.reqPage == pnum} ? 'active'" href="" th:href="@{/MyHomePrice/list/{reqPage}/{contractDate}/{contractDateTo}/{searchSidoCd}/{searchGugunCd}/{searchDongCd}/{searchArea}/{searchAreaValue}/{searchAreaValueTo}/{searchFromAmount}/{searchToAmnount}
        (reqPage=${pnum}, contractDate=${fc.contractDate},contractDateTo=${fc.contractDateTo},searchSidoCd=${fc.searchSidoCd},searchGugunCd=${fc.searchGugunCd},searchDongCd=${fc.searchDongCd},searchArea=${fc.searchArea}
        ,searchAreaValue=${fc.searchAreaValue},searchAreaValueTo=${fc.searchAreaValueTo},searchFromAmount=${fc.searchFromAmount},searchToAmnount=${fc.searchToAmnount})}"
           th:text="${pnum}">1</a>
      </th:block>
    </th:block>
    <!--                ë¤ìíì´ì§ì ë³´-->
    <th:block th:if="${fc.next}">
      <a class="AptPrice-page-item" href=""
         th:href="@{/MyHomePrice/list/{reqPage}/{contractDate}/{contractDateTo}/{searchSidoCd}/{searchGugunCd}/{searchDongCd}/{searchArea}/{searchAreaValue}/{searchAreaValueTo}/{searchFromAmount}/{searchToAmnount}
        (reqPage=${fc.endPage+1}, contractDate=${fc.contractDate},contractDateTo=${fc.contractDateTo},searchSidoCd=${fc.searchSidoCd},searchGugunCd=${fc.searchGugunCd},searchDongCd=${fc.searchDongCd},searchArea=${fc.searchArea}
        ,searchAreaValue=${fc.searchAreaValue},searchAreaValueTo=${fc.searchAreaValueTo},searchFromAmount=${fc.searchFromAmount},searchToAmnount=${fc.searchToAmnount})}">
        <i class="fas fa-angle-right"></i>
      </a>
      <a class="AptPrice-page-item" href=""
         th:href="@{/MyHomePrice/list/{reqPage}/{contractDate}/{contractDateTo}/{searchSidoCd}/{searchGugunCd}/{searchDongCd}/{searchArea}/{searchAreaValue}/{searchAreaValueTo}/{searchFromAmount}/{searchToAmnount}
        (reqPage=${fc.finalEndPage}, contractDate=${fc.contractDate},contractDateTo=${fc.contractDateTo},searchSidoCd=${fc.searchSidoCd},searchGugunCd=${fc.searchGugunCd},searchDongCd=${fc.searchDongCd},searchArea=${fc.searchArea}
        ,searchAreaValue=${fc.searchAreaValue},searchAreaValueTo=${fc.searchAreaValueTo},searchFromAmount=${fc.searchFromAmount},searchToAmnount=${fc.searchToAmnount})}">
        <i class="fas fa-angle-double-right"></i>
      </a>
    </th:block>
  </div>
  </div>
  <script>
      // ëí í´ìíê·¸ ì ë³´ íì¤í¸ ìì # ë¶ì´ê¸°
      const $mainHashtag = document.querySelectorAll('.mainHashtag');

      $mainHashtag.forEach(ele => {
          if (ele.textContent.trim().length > 1) {
              const $hashtagView = " #" + ele.textContent;
              ele.textContent = $hashtagView;
          }
      });
  </script>

  <script th:inline="javascript">
      /* Function to create the chart */

      function createChart(item) {
          const transactioncountlist = item.transactioncountlist;
          const transactioncountlistArr = transactioncountlist.split(',');

          const contract = item.contract;
          const contractArr = contract.split(',');

          /* Data for the chart */
          var data = {
              labels: contractArr,
              datasets: [{
                  label: 'ê±°ëê¸ì¡',
                  data: transactioncountlistArr,
                  backgroundColor: 'rgba(255, 99, 132, 0.2)',
                  borderColor: 'rgba(255, 99, 132, 1)',
                  borderWidth: 1
              }]
          };
          // console.log(data);
          /* Options for the chart */
          var options = {};

          /* Get the canvas element */
          var ctx = document.getElementById('chart-' + item.apt_id + ' canvas').getContext('2d');

          /* Create the chart */
          new Chart(ctx, {
              type: 'line',
              data: data,
              options: options
          });
      }

      /* Loop through the chart data */
      [[${list}]].forEach(function (item) {
          createChart(item);
      });
  </script>

</main>
</body>
</html>