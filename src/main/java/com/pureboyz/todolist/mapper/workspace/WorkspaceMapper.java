package com.pureboyz.todolist.mapper.workspace;

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
@Repository("com.pureboyz.todolist.mapper.workspace.WorkspaceMapper")
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

}
