package egovframework.aptSurfer.main.service.impl;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import egovframework.aptSurfer.main.service.MainService;
import net.sf.json.JSONObject;
/**
 * @Class Name : egovframework.aptSurfer.common.mapper.CommonServiceImpl
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
@Service("MainService")
public class MainServiceImpl implements MainService {


	// 수입검사요청 맵퍼
	@Autowired
	private MainService mainService;

	/**
	 * 화면
	 */
	@Override
	public String mainView(HttpServletRequest request, ModelMap model) throws Exception {

		return "/main/MainView";
	}

	@Override
	public List<JSONObject> getMyHomePriceList(JSONObject param) throws Exception {
		
		//목록
		
		//차트
		
		//페이징
		
		
		return null;
	}
	
}
