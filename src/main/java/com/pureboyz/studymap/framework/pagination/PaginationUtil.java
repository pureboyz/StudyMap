package com.pureboyz.studymap.framework.pagination;

import org.springframework.stereotype.Service;

import com.pureboyz.studymap.framework.mymap.MyMap;

@Service("PaginationUtil")
public class PaginationUtil
{
	/**
	 * <pre>
	 * MethodName 	: getPagination
	 * Date 		: 2019. 12. 17.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap, int, int, int, int 
	 * ReturnType 	: Pagination
	 *
	 * 현재 페이지, 총 게시글 수, 한 페이지당 게시글 수, 보여지는 페이지 수
	 * 4개의 매개변수를 받아서 페이징정보를 세팅하고
	 * MySQL의 LIMIT에서 사용할 #{start}, #{countPerPage}를 세팅한 후
	 * Pagination Map 객체를 반환한다.
	 * 
	 * </pre>
	 */
	public MyMap getPagination(MyMap paramMap, int currentPage, int totalCount, int countPerPage, int displayPageCount)
	{
		MyMap 		paginationMap 	= new MyMap();
		Pagination 	pagination 		= new Pagination();
		
		pagination.setCurrentPage(currentPage);
		pagination.setTotalCount(totalCount);
		pagination.setCountPerPage(countPerPage);
		pagination.setDisplayPageCount(displayPageCount);
		
		paginationMap.put("currentPage", 		pagination.getCurrentPage());
		paginationMap.put("totalCount", 		pagination.getTotalCount());
		paginationMap.put("countPerPage", 		pagination.getCountPerPage());
		paginationMap.put("start", 				pagination.getStart());
		paginationMap.put("end", 				pagination.getEnd());
		paginationMap.put("displayPageCount", 	pagination.getDisplayPageCount());
		paginationMap.put("startPage", 			pagination.getStartPage());
		paginationMap.put("endPage", 			pagination.getEndPage());
		paginationMap.put("prev", 				pagination.isPrev());
		paginationMap.put("next", 				pagination.isNext());
		
		paramMap.put("start", 			paginationMap.getInt("start") - 1);
		paramMap.put("countPerPage", 	paginationMap.getInt("countPerPage"));
		
		return paginationMap;
	}
}
