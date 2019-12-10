package com.pureboyz.studymap.web.index.act;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pureboyz.studymap.framework.beans.FrameworkBeans;
import com.pureboyz.studymap.framework.mymap.MyCamelMap;
import com.pureboyz.studymap.framework.mymap.MyMap;
import com.pureboyz.studymap.web.index.service.IndexService;
import com.pureboyz.studymap.web.workspace.service.WorkspaceService;

/**
 * <pre>
 * Date 		: 2019. 12. 8.
 * Author 		: pureboyz
 *
 * 페이지 이동을 담당하는 Controller
 * 
 * </pre>
 */
@RequestMapping("/")
@Controller
public class IndexAct
{
	@Resource(name="com.pureboyz.studymap.web.workspace.service.WorkspaceService")
	WorkspaceService workspaceService;
	
	@Resource(name="com.pureboyz.studymap.web.index.service.IndexService")
	IndexService indexService;
	
	/**
	 * <pre>
	 * MethodName 	: Index
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: 
	 * ReturnType 	: String
	 *
	 * 메인(로그인) 페이지
	 * 
	 * </pre>
	 */
	@RequestMapping(value= {"", "/"})
	public String Index()
	{
		return "/Index";
	}
	
	/**
	 * <pre>
	 * MethodName 	: login
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: 
	 * ReturnType 	: String
	 *
	 * 로그인
	 * 
	 * </pre>
	 */
	@RequestMapping("/login")
	public @ResponseBody String login()
	{
		MyMap paramMap = FrameworkBeans.findHttpServletBean().findClientRequestParameter();
		
		MyCamelMap resultMap = indexService.SelectUserByIdAndPassword(paramMap);
		if(resultMap != null)
		{
			FrameworkBeans.findSessionBean().setSESSION_SEQUSERINFO(String.valueOf(resultMap.getInt("sequserinfo")));
			FrameworkBeans.findSessionBean().setSESSION_ID(resultMap.getStr("id"));
			return "Success!";
		}
		else
		{
			return "Fail!";
		}
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
	 * </pre>
	 */
	@RequestMapping("/Workspace")
	public String Workspace(Model model)
	{
		MyMap paramMap = FrameworkBeans.findHttpServletBean().findClientRequestParameter();
		
		List<MyCamelMap> workspaceList = workspaceService.SelectWorkspaceListBySequser(paramMap);
		model.addAttribute("list", workspaceList);
		
		if(workspaceList.size() > 0)
		{
			MyCamelMap workspaceMap = new MyCamelMap();
			if(!paramMap.getStr("seqworkspace", "").equals(""))
			{
				workspaceMap = workspaceService.SelectedWorkspace(paramMap);
			}
			else
			{
				workspaceMap.put("seqworkspace", workspaceList.get(0).get("seqworkspace"));
			}
			model.addAttribute("workspaceMap", workspaceMap);
		}
		
		return "/workspace/Workspace";
	}
	
	/**
	 * <pre>
	 * MethodName 	: Schedule
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: Model
	 * ReturnType 	: String
	 *
	 * Schedule 메인 페이지로 이동.
	 * 
	 * </pre>
	 */
	@RequestMapping("/Schedule")
	public String Schedule()
	{
		return "/schedule/Schedule";
	}
}
