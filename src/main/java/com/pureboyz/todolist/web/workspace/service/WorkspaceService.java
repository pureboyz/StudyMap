package com.pureboyz.todolist.web.workspace.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pureboyz.todolist.mapper.workspace.WorkspaceMapper;

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

}
