'use strict';

//계약일자 오늘날짜
document.getElementById('contractDate').value = new Date().toISOString().substring(0, 10);
document.getElementById('contractDateTo').value = new Date().toISOString().substring(0, 10);

// 주소구분 라디오 이벤트
const gubunR1 = document.getElementById('gubunR1');
gubunR1.addEventListener('click', fn_select_check)
const searchDongCd = document.getElementById("searchDongCd");
const searchChosung = document.getElementById("searchChosung");
const searchLoad = document.getElementById("searchLoad");
searchDongCd.style.cssText = "display: block; ";
searchChosung.style.cssText = "display: none; ";
searchLoad.style.cssText = "display: none; ";

function fn_select_check(e) {
    if (e == 1) {
        console.log(e);
        searchDongCd.style.cssText = "display: block; ";
        searchChosung.style.cssText = "display: none; ";
        searchLoad.style.cssText = "display: none; ";
    } else if (e == 2) {
        console.log(e);
        searchDongCd.style.cssText = "display: none; ";
        searchChosung.style.cssText = "display: block; ";
        searchLoad.style.cssText = "display: block; ";
    }
}

//주소 셀렉트 박스 이벤트
const searchSidoCd = document.getElementById('searchSidoCd');
searchSidoCd.addEventListener('click', sidoCd)
const searchGugunCd = document.getElementById("searchGugunCd");
searchGugunCd.addEventListener('click', gugunCd)

//시도
function sidoCd(e) {
    if (e != '[object PointerEvent]') {
        const url = '/regionCounty/' + e;
        fn_sgg_search(e, url, cbSidoCd)
    }
}

//시군구
function gugunCd(e) {
    if (e != '[object PointerEvent]') {
        const url = '/regionDistricts/' + e;
        fn_sgg_search(e, url, cbGugunCd)
    }
}

//ajax 호출
function fn_sgg_search(param, url, cbSuccess) {
    fetch(url, {
        method: 'GET',
    })
        .then((res) => res.json())
        .then((res) => cbSuccess(res))
        .catch((err) => {
            console.error('Err:', err);
        });
}

//시도 -> 시군구 데이터 셋
function cbSidoCd(res) {
    const searchGugunCd = document.getElementById("searchGugunCd");
    searchGugunCd.add = res.data;

    for (var i = 0; i < res.data.length; i++) {
        var opt = document.createElement("option");
        opt.value = res.data[i].county_CODE;
        opt.innerHTML = res.data[i].county_NM;
        searchGugunCd.appendChild(opt);
    }
}

//시군구 -> 읍면동 데이터 셋
function cbGugunCd(res) {
    const searchDongCd = document.getElementById("searchDongCd");
    searchDongCd.add = res.data;

    for (var i = 0; i < res.data.length; i++) {
        var opt = document.createElement("option");
        opt.value = res.data[i].districts_CODE;
        opt.innerHTML = res.data[i].districts_NM;
        searchDongCd.appendChild(opt);
    }
}

//필수값 체크
let $files5 = document.getElementById("files5").value;
// 조회 버튼
searchBtn?.addEventListener('click', e=> {
  // var $files5 = document.getElementById("files5").value;
  // if(!$files5){
  //   alert("썸네일 파일을 첨부해 주세요");
  //   return false;
  // }else{
    writeForm.submit();
  // }
});






//검색
const $keyword = document.getElementById('keyword');
const $searchBtn = document.getElementById('searchBtn');

//검색 버튼 클릭시
$searchBtn?.addEventListener('click', search_f);

//키워드 입력창 엔터키 눌렀을때 검색
$keyword?.addEventListener('keydown', e => {
    if (e.key === 'Enter') {
        search_f(e);
    }
});

function search_f(e) {
    //해시태그 검색
    if ($hashtag.childElementCount >= 1) {
        let $selectedTags = $hashtag.getElementsByClassName('tag_name');
        $keyword.value = ``;
        for (let i = 0; i < $selectedTags.length; i++) {
            $keyword.value += $selectedTags[i].textContent;
            if (i != $selectedTags.length - 1) {
                $keyword.value += ', ';
            }
        }
        const url = `/coffeeShop/list/1/${$searchType.value}/${$keyword.value}`;
        location.href = url;
    }

    //키워드 검색
    //입력값 유무 체크
    if ($keyword.value.trim().length === 0) {
        alert('검색어를 입력하세요');
        $keyword.focus();
        $keyword.select(); //커서이동
        return false;
    }

    const url = `/coffeeShop/list/1/${$searchType.value}/${$keyword.value}`;
    location.href = url;
}