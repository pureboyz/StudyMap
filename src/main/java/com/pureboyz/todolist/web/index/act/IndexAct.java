package com.pureboyz.todolist.web.index.act;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pureboyz.todolist.framework.beans.FrameworkBeans;
import com.pureboyz.todolist.web.index.service.IndexService;
import com.pureboyz.todolist.web.workspace.service.WorkspaceService;

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
	@Resource(name="com.pureboyz.todolist.web.workspace.service.WorkspaceService")
	WorkspaceService workspaceService;
	
	@Resource(name="com.pureboyz.todolist.web.index.service.IndexService")
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
	public @ResponseBody String login(String id, String password)
	{
		Map<String, String> userMap = new HashMap<>();
		userMap.put("id", 		id);
		userMap.put("password", password);
		
		List<Map<String, Object>> resultList = indexService.SelectUserByIdAndPassword(userMap);
		if(resultList.size() > 0)
		{
			FrameworkBeans.findSessionBean().setId(id);
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
		List<Map<String, Object>> workspaceList = workspaceService.SelectWorkspaceList();
		model.addAttribute("list", workspaceList);
		
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