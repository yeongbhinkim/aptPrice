package egovframework.aptSurfer.common.mapper;


import java.util.List;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import net.sf.json.JSONObject;

/**
 * @Class Name : egovframework.aptSurfer.common.mapper.CommonMapper
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

@Mapper("CommonMapper")
public interface CommonMapper {

	/**
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<JSONObject> selectCommonList(JSONObject param) throws Exception;
	/**
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject selectCommonInfo(JSONObject param) throws Exception;

	public void mergeCommonInfo(JSONObject param) throws Exception;

	public void deleteCommonInfo(JSONObject param) throws Exception;
}
