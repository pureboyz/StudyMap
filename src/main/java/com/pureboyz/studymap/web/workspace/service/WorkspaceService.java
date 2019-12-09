package com.pureboyz.studymap.web.workspace.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pureboyz.studymap.mapper.workspace.WorkspaceMapper;

/**
 * <pre>
 * Date 		: 2019. 12. 8.
 * Author 		: pureboyz
 *
 * Workspace 관련 Service.
 * 
 * </pre>
 */
@Service("com.pureboyz.todolist.web.workspace.service.WorkspaceService")
public class WorkspaceService
{
	@Resource(name="com.pureboyz.todolist.mapper.workspace.WorkspaceMapper")
	WorkspaceMapper workspaceMapper;

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
	public List<Map<String, Object>> SelectWorkspaceList()
	{
		return workspaceMapper.SelectWorkspaceList();
	}

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
	public Map<String, Object> SelectWorkspaceByTitleAndSequser(Map<String, Object> paramMap)
	{
		return workspaceMapper.SelectWorkspaceByTitleAndSequser(paramMap);
	}

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
	public int InsertWorkspace(Map<String, Object> paramMap)
	{
		return workspaceMapper.InsertWorkspace(paramMap);
	}

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
	public Map<String, Object> SelectedWorkspace(String seqworkspace)
	{
		return workspaceMapper.SelectedWorkspace(seqworkspace);
	}

}
