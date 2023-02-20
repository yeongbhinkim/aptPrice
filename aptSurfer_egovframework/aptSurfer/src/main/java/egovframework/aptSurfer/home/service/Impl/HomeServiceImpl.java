package egovframework.aptSurfer.home.service.Impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import egovframework.aptSurfer.home.mapper.HomeMapper;
import egovframework.aptSurfer.home.service.HomeService;
import net.sf.json.JSONObject;
/**
 * @Class Name : egovframework.aptSurfer.home.mapper.homeServiceImpl
 * @Description :  aptSurfer 공통
 * @Modification Information
 * @ 
 * @ 수정일 		 수정자 		수정내용
 * @ ---------- --------- ------------------------------- 
 * @
 * @ 2023.02.19  KIM 		최초생성
 * @author KIM
 * @since 2023.02.19
 * @version 1.0.0
 * @see
 * copyright (c) KIM.inc All rights reserved.
 */
@Service("HomeService")
public class HomeServiceImpl implements HomeService {


	// 맵퍼
	@Autowired(required = false)
	private HomeMapper homeMapper;

	/**
	 * 화면
	 */
	@Override
	public String homeView(HttpServletRequest request, ModelMap model) throws Exception {

		return "/home/homeView";
	}
	/**
	 * 시도 조회
	 */
	@Override
	public JSONObject getRegionCity(JSONObject param) throws Exception {
		
		return homeMapper.selectRegionCity(param);
	}
	/**
	 * 시군구 조회
	 */
	@Override
	public JSONObject getRegionCounty(JSONObject param) throws Exception {
		
		return homeMapper.selectRegionCounty(param);
	}
	/**
	 * 읍면동 조회
	 */
	@Override
	public JSONObject getRegionDistricts(JSONObject param) throws Exception {
		
		return homeMapper.selectRegionDistricts(param);
	}

}