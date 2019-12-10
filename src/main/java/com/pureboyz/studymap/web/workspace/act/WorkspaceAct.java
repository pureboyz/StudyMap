package com.pureboyz.studymap.web.workspace.act;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
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
	
}
