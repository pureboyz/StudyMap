package com.pureboyz.studymap.web.workspace.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pureboyz.studymap.framework.mymap.MyCamelMap;
import com.pureboyz.studymap.framework.mymap.MyMap;
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
@Service("com.pureboyz.studymap.web.workspace.service.WorkspaceService")
public class WorkspaceService
{
	@Resource(name="com.pureboyz.studymap.mapper.workspace.WorkspaceMapper")
	WorkspaceMapper workspaceMapper;

	/**
	 * <pre>
	 * MethodName 	: SelectWorkspaceList
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap
	 * ReturnType 	: List<MyCamelMap>
	 *
	 * Workspace List를 가져온다.
	 * 
	 * </pre>
	 * @param paramMap 
	 */
	public List<MyCamelMap> SelectWorkspaceListBySequser(MyMap paramMap)
	{
		return workspaceMapper.SelectWorkspaceListBySequser(paramMap);
	}

	/**
	 * <pre>
	 * MethodName 	: SelectWorkspaceByTitleAndUserid
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap
	 * ReturnType 	: MyCamelMap
	 *
	 * title과 sequser로 Workspace를 가져온다.
	 * 
	 * </pre>
	 */
	public MyCamelMap SelectWorkspaceByTitleAndSequser(MyMap paramMap)
	{
		return workspaceMapper.SelectWorkspaceByTitleAndSequser(paramMap);
	}

	/**
	 * <pre>
	 * MethodName 	: InsertWorkspace
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap
	 * ReturnType 	: int
	 *
	 * Workspace를 추가한다.
	 * 
	 * </pre>
	 */
	public int InsertWorkspace(MyMap paramMap)
	{
		return workspaceMapper.InsertWorkspace(paramMap);
	}

	/**
	 * <pre>
	 * MethodName 	: SelectedWorkspace
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap
	 * ReturnType 	: MyCamelMap
	 *
	 * 현재 선택된 Workspace
	 * 
	 * </pre>
	 */
	public MyCamelMap SelectedWorkspace(MyMap paramMap)
	{
		return workspaceMapper.SelectedWorkspace(paramMap);
	}

	/**
	 * <pre>
	 * MethodName 	: SelectPostingListBySeqworkspace
	 * Date 		: 2019. 12. 12.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap
	 * ReturnType 	: List<MyCamelMap>
	 *
	 * 선택된 Workspace의 PostingList
	 * 
	 * </pre>
	 */
	public List<MyCamelMap> SelectPostingListBySeqworkspace(MyMap paramMap)
	{
		return workspaceMapper.SelectPostingListBySeqworkspace(paramMap);
	}

}
