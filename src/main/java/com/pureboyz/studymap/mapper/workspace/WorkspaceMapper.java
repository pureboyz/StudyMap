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
/**
 * <pre>
 * Date 		: 2019. 12. 14.
 * Author 		: pureboyz
 *
 * 
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
	List<MyCamelMap> SelectPostingListBySeqworkspace(MyMap paramMap);

	/**
	 * <pre>
	 * MethodName 	: InsertPosting
	 * Date 		: 2019. 12. 14.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap
	 * ReturnType 	: int
	 *
	 * Posting 등록.
	 * 
	 * </pre>
	 */
	int InsertPosting(MyMap paramMap);

	
	/**
	 * <pre>
	 * MethodName 	: DeletePosting
	 * Date 		: 2019. 12. 14.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap
	 * ReturnType 	: int
	 *
	 * Posting 삭제.
	 * 
	 * </pre>
	 */
	int DeletePosting(MyMap paramMap);

	/**
	 * <pre>
	 * MethodName 	: SelectPostingBySeqpostinglist
	 * Date 		: 2019. 12. 16.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap
	 * ReturnType 	: MyMap
	 *
	 *  Posting 상세 페이지.
	 * 
	 * </pre>
	 */
	MyMap SelectPostingBySeqpostinglist(MyMap paramMap);

	/**
	 * <pre>
	 * MethodName 	: ModifyPosting
	 * Date 		: 2019. 12. 16.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap
	 * ReturnType 	: int
	 *
	 * Posting 수정.
	 * 
	 * </pre>
	 */
	int ModifyPosting(MyMap paramMap);

}
