package egovframework.aptSurfer.main.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import net.sf.json.JSONObject;

/**
 * @Class Name : egovframework.aptSurfer.common.mapper.CommonService
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

public interface MainService {

	/**
	 * 화면
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String mainView(HttpServletRequest request, ModelMap model) throws Exception;

	/**
	 * APT 조건 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject getMyHomePriceList(JSONObject param) throws Exception;
	
}
