package com.pureboyz.studymap.web.workspace.act;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pureboyz.studymap.framework.beans.FrameworkBeans;
import com.pureboyz.studymap.framework.mymap.MyCamelMap;
import com.pureboyz.studymap.framework.mymap.MyMap;
import com.pureboyz.studymap.framework.pagination.PaginationUtil;
import com.pureboyz.studymap.framework.result.ResultCode;
import com.pureboyz.studymap.framework.result.ResultMessage;
import com.pureboyz.studymap.web.workspace.service.WorkspaceService;

/**
 * <pre>
 * Date 		: 2019. 12. 8.
 * Author 		: pureboyz
 *
 * Workspace 관련 Controller
 * 
 * </pre>
 */
@RequestMapping("/Workspace")
@Controller
public class WorkspaceAct
{
	@Resource(name="com.pureboyz.studymap.web.workspace.service.WorkspaceService")
	WorkspaceService workspaceService;
	
	@Resource(name="PaginationUtil")
	PaginationUtil paginationUtil;
	
	/**
	 * <pre>
	 * MethodName 	: AsideInfo
	 * Date 		: 2019. 12. 14.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: MyMap
	 * ReturnType 	: MyMap
	 *
	 * Workspace의 aside에서 사용될 정보를 반환한다.
	 * 
	 * 필수 parameter
	 * ${SESSION_SEQUSERINFO}, ${seqworkspace}
	 * 
	 * </pre>
	 */
	public MyMap AsideInfo(MyMap paramMap)
	{
		MyMap 				returnMap 			= new MyMap();
		List<MyCamelMap> 	workspaceList 		= null;				// 로그인한 유저의 Workspace 목록
		MyCamelMap 			workspaceMap 		= null;				// 선택된 Workspace
		List<MyCamelMap> 	postingList 		= null;				// 선택된 Workspace의 PostingList
		int 				postingListCnt		= 0;				// 선택된 Workspace의 PostingList 총 갯수
		MyMap 				postingPagination 	= new MyMap();	// 페이징객체
		
		workspaceList = workspaceService.SelectWorkspaceListBySequser(paramMap);
		
		if(workspaceList.size() > 0)
		{
			if(!paramMap.getStr("seqworkspace", "").equals(""))
			{
				// 현재 선택된 Workspace
				workspaceMap = workspaceService.SelectedWorkspace(paramMap);
			}
			else
			{
				workspaceMap = workspaceList.get(0);
			}
			
		}
		
		try
		{
			paramMap.put("seqworkspace", workspaceMap.getInt("seqworkspace", 0));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		postingListCnt 		= workspaceService.SelectPostingListCount(paramMap);
		postingPagination 	= paginationUtil.getPagination(paramMap, paramMap.getInt("page", 1), postingListCnt, 15, 10);
		postingList 		= workspaceService.SelectPostingListBySeqworkspace(paramMap);
		
		returnMap.put("workspaceList", 		workspaceList);
		returnMap.put("workspaceMap", 		workspaceMap);
		returnMap.put("postingList", 		postingList);
		returnMap.put("postingPagination", 	postingPagination);
		
		System.out.println("postingPagination : " + postingPagination);
		
		return returnMap;
	}
	
	/**
	 * <pre>
	 * MethodName 	: Workspace
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: Model
	 * ReturnType 	: String
	 *
	 * Workspace 메인 페이지로 이동.
	 * 
	 * 필수 parameter
	 * ${SESSION_SEQUSERINFO}, ${seqworkspace}
	 * 
	 * </pre>
	 */
	@RequestMapping(value= {"", "/"})
	public String Workspace(Model model)
	{
		MyMap paramMap = FrameworkBeans.findHttpServletBean().findClientRequestParameter();
		
		model.addAttribute("aside", AsideInfo(paramMap));
		
		return "/workspace/Workspace";
	}
	
	/**
	 * <pre>
	 * MethodName 	: InsertWorkspace
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: 
	 * ReturnType 	: ResultMessage
	 *
	 * Workspace 등록
	 * 
	 * 필수 parameter
	 * ${workspaceTitle}, ${SESSION_SEQUSERINFO}
	 * 
	 * </pre>
	 */
	@RequestMapping("/InsertWorkspace")
	public @ResponseBody ResultMessage InsertWorkspace()
	{
		MyMap paramMap = FrameworkBeans.findHttpServletBean().findClientRequestParameter();
		
		MyCamelMap resultMap = workspaceService.SelectWorkspaceByTitleAndSequser(paramMap);
		if(resultMap != null)
		{
			return new ResultMessage(ResultCode.RESULT_BAD_REQUEST, "Fail!", "이미 등록된 이름입니다.");
		}
		else
		{
			int result = workspaceService.InsertWorkspace(paramMap);
			if(result > 0)
			{
				return new ResultMessage(ResultCode.RESULT_OK, "Success!");
			}
			else
			{
				return new ResultMessage(ResultCode.RESULT_BAD_REQUEST, "Fail!", "다시 시도해주세요.");
			}
		}
	}
	
	/**
	 * <pre>
	 * MethodName 	: RegistPosting
	 * Date 		: 2019. 12. 12.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: Model
	 * ReturnType 	: String
	 *
	 * Posting 작성 페이지로 이동.
	 * 
	 * 필수 parameter
	 * ${SESSION_SEQUSERINFO}, ${seqworkspace}
	 * 
	 * </pre>
	 */
	@RequestMapping("/RegistPosting")
	public String RegistPosting(Model model)
	{
		MyMap paramMap = FrameworkBeans.findHttpServletBean().findClientRequestParameter();
		
		model.addAttribute("aside", AsideInfo(paramMap));
		
		return "/workspace/RegistPosting";
	}
	
	/**
	 * <pre>
	 * MethodName 	: InsertPosting
	 * Date 		: 2019. 12. 14.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: Model, RedirectAttributes
	 * ReturnType 	: String
	 *
	 * Posting 등록.
	 * 
	 * 필수 parameter
	 * #{postingTitle}, #{SESSION_ID}, #{postingContent}, #{SESSION_SEQUSERINFO}, #{seqworkspace}
	 * 
	 * </pre>
	 */
	@RequestMapping("/InsertPosting")
	public String InsertPosting(Model model, RedirectAttributes rttr)
	{
		MyMap paramMap = FrameworkBeans.findHttpServletBean().findClientRequestParameter();
		
		workspaceService.InsertPosting(paramMap);
		
		rttr.addAttribute("seqworkspace", paramMap.getInt("seqworkspace"));
		
		return "redirect:/Workspace";
	}
	
	/**
		 * <pre>
		 * MethodName 	: DeletePosting
		 * Date 		: 2019. 12. 14.
		 * Author 		: pureboyz
		 * 
		 * ParamsType 	: 
		 * ReturnType 	: ResultMessage
		 *
		 * Posting 삭제.
		 * 
		 * 필수 parameter
		 * ${seqpostinglist}
		 * 
		 * </pre>
		 */
	@RequestMapping("/DeletePosting")
	public @ResponseBody ResultMessage DeletePosting()
	{
		MyMap paramMap = FrameworkBeans.findHttpServletBean().findClientRequestParameter();
		
		int result = workspaceService.DeletePosting(paramMap);
		
		if(result > 0)
		{
			return new ResultMessage(ResultCode.RESULT_OK, "Success!");
		}
		else
		{
			return new ResultMessage(ResultCode.RESULT_BAD_REQUEST, "Fail!");
		}
	}
	
	/**
	 * <pre>
	 * MethodName 	: DetailPosting
	 * Date 		: 2019. 12. 16.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: Model
	 * ReturnType 	: String
	 *
	 * Posting 상세 페이지.
	 *
	 * 필수 parameter
	 * ${SESSION_SEQUSERINFO}, ${seqworkspace}, #{seqpostinglist}
	 * 
	 * </pre>
	 */
	@RequestMapping("/DetailPosting")
	public String DetailPosting(Model model)
	{
		MyMap paramMap = FrameworkBeans.findHttpServletBean().findClientRequestParameter();
		
		MyMap postingMap = workspaceService.SelectPostingBySeqpostinglist(paramMap);
		
		model.addAttribute("aside", 		AsideInfo(paramMap));
		model.addAttribute("postingMap", 	postingMap);
		
		return "/workspace/DetailPosting";
	}
	
	/**
	 * <pre>
	 * MethodName 	: ModifyPosting
	 * Date 		: 2019. 12. 16.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: Model, RedirectAttributes
	 * ReturnType 	: String
	 *
	 * Posting 수정.
	 * 
	 * </pre>
	 */
	@RequestMapping("/ModifyPosting")
	public String ModifyPosting(Model model, RedirectAttributes rttr)
	{
		MyMap paramMap = FrameworkBeans.findHttpServletBean().findClientRequestParameter();
		
		workspaceService.ModifyPosting(paramMap);
		
		rttr.addAttribute("seqworkspace", paramMap.getInt("seqworkspace"));
		
		return "redirect:/Workspace";
	}
	
}
