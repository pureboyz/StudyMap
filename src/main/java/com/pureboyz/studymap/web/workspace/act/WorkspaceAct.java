package com.pureboyz.studymap.web.workspace.act;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pureboyz.studymap.framework.beans.FrameworkBeans;
import com.pureboyz.studymap.framework.mymap.MyCamelMap;
import com.pureboyz.studymap.framework.mymap.MyMap;
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
	 * </pre>
	 */
	@RequestMapping(value= {"", "/"})
	public String Workspace(Model model)
	{
		MyMap 				paramMap 		= FrameworkBeans.findHttpServletBean().findClientRequestParameter();
		List<MyCamelMap> 	workspaceList 	= null;	// 로그인한 유저의 Workspace 목록
		MyCamelMap 			workspaceMap 	= null;	// 선택된 Workspace
		List<MyCamelMap> 	postingList 	= null;	// 선택된 Workspace의 PostingList
		
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
		
		paramMap.put("seqworkspace", workspaceMap.getInt("seqworkspace"));
		postingList = workspaceService.SelectPostingListBySeqworkspace(paramMap);
		
		model.addAttribute("workspaceList", workspaceList);
		model.addAttribute("workspaceMap", 	workspaceMap);
		model.addAttribute("postingList", 	postingList);
		
		return "/workspace/Workspace";
	}
	
	/**
	 * <pre>
	 * MethodName 	: Index
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: 
	 * ReturnType 	: String
	 *
	 * Workspace 등록
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
	 * ParamsType 	: 
	 * ReturnType 	: String
	 *
	 * Posting 작성 페이지로 이동.
	 * 
	 * </pre>
	 */
	@RequestMapping("/RegistPosting")
	public String RegistPosting()
	{
		return "/workspace/RegistPosting";
	}
	
}
