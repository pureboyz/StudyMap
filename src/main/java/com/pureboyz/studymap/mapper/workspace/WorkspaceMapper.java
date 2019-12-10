package com.pureboyz.studymap.mapper.workspace;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pureboyz.studymap.framework.mymap.MyCamelMap;
import com.pureboyz.studymap.framework.mymap.MyMap;

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
	 * ParamsType 	: MyMap
	 * ReturnType 	: List<MyCamelMap>
	 *
	 * Workspace List를 가져온다.
	 * 
	 * </pre>
	 * @param paramMap 
	 */
	List<MyCamelMap> SelectWorkspaceListBySequser(MyMap paramMap);

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
	MyCamelMap SelectWorkspaceByTitleAndSequser(MyMap paramMap);

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
	int InsertWorkspace(MyMap paramMap);

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
	MyCamelMap SelectedWorkspace(MyMap paramMap);

}
