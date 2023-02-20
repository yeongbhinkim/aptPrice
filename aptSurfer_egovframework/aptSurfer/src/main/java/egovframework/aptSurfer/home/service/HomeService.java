package egovframework.aptSurfer.home.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import net.sf.json.JSONObject;

/**
 * @Class Name : egovframework.aptSurfer.home.mapper.homeService
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

public interface HomeService {

	/**
	 * 화면
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String homeView(HttpServletRequest request, ModelMap model) throws Exception;

	/**
	 * 시도 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject getRegionCity(JSONObject param) throws Exception;
	/**
	 * 시군구 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject getRegionCounty(JSONObject param) throws Exception;
	/**
	 * 읍면동 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject getRegionDistricts(JSONObject param) throws Exception;
	
}