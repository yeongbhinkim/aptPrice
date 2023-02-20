package egovframework.aptSurfer.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.aptSurfer.home.service.HomeService;
import net.sf.json.JSONObject;
/**
 * @Class Name : egovframework.aptSurfer.home.mapper.HomeController
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
@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired(required = false)
	private HomeService homeService;

	/**
	 * 화면
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/homeView")
	public String homeView(HttpServletRequest request, ModelMap model) throws Exception {
		System.out.println("asd");
		return homeService.homeView(request, model);
	}

	/**
	 * 시도 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRegionCity")
	@ResponseBody
	public JSONObject getRegionCity(@RequestBody JSONObject param) throws Exception {

		return homeService.getRegionCity(param);
	}
	
	/**
	 * 시군구 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRegionCounty")
	@ResponseBody
	public JSONObject getRegionCounty(@RequestBody JSONObject param) throws Exception {
		
		return homeService.getRegionCounty(param);
	}
	
	/**
	 * 읍면동 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRegionDistricts")
	@ResponseBody
	public JSONObject getRegionDistricts(@RequestBody JSONObject param) throws Exception {
		
		return homeService.getRegionDistricts(param);
	}

}