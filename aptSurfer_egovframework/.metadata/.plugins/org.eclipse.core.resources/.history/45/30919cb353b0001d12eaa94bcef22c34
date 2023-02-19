package egovframework.aptSurfer.common.service;


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

public interface CommonService {

	/**
	 * 화면
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String commonView(HttpServletRequest request, ModelMap model) throws Exception;

	/**
	 * 팝업
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String popupcommonView(HttpServletRequest request, ModelMap model) throws Exception;

	/**
	 * 목록 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> getCommonList(JSONObject param) throws Exception;

	/**
	 * 정보 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject getCommonInfo(JSONObject param) throws Exception;

	/**
	 * 저장
	 * 
	 * @param param
	 * @throws Exception
	 */
	public void setCommonInfo(JSONObject param) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param param
	 * @throws Exception
	 */
	public void removeCommonInfo(JSONObject param) throws Exception;
	
	/**
	 * 페이징 계산
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject pageCriteria(JSONObject param) throws Exception;
	
}
