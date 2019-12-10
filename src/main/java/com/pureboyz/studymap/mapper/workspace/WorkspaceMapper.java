package com.pureboyz.studymap.mapper.workspace;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Date 		: 2019. 12. 8.
 * Author 		: pureboyz
 *
 * Workspace Table에 대한 쿼리 담당.
 * 
 * </pre>
 */
@Mapper
@Repository("com.pureboyz.studymap.mapper.workspace.WorkspaceMapper")
public interface WorkspaceMapper
{

	/**
	 * <pre>
	 * MethodName 	: SelectWorkspaceList
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: 
	 * ReturnType 	: List<Map<String,Object>>
	 *
	 * Workspace List를 가져온다.
	 * 
	 * </pre>
	 */
	List<Map<String, Object>> SelectWorkspaceList();

	/**
	 * <pre>
	 * MethodName 	: SelectWorkspaceByTitleAndUserid
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: Map<String, Object>
	 * ReturnType 	: Map<String,Object>
	 *
	 * title과 sequser로 Workspace를 가져온다.
	 * 
	 * </pre>
	 */
	Map<String, Object> SelectWorkspaceByTitleAndSequser(Map<String, Object> paramMap);

	/**
	 * <pre>
	 * MethodName 	: InsertWorkspace
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: Map<String, Object>
	 * ReturnType 	: int
	 *
	 * Workspace를 추가한다.
	 * 
	 * </pre>
	 */
	int InsertWorkspace(Map<String, Object> paramMap);

	/**
	 * <pre>
	 * MethodName 	: SelectedWorkspace
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: String
	 * ReturnType 	: Map<String,Object>
	 *
	 * 현재 선택된 Workspace
	 * 
	 * </pre>
	 */
	Map<String, Object> SelectedWorkspace(String seqworkspace);

}
