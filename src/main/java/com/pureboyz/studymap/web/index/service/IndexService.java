package com.pureboyz.studymap.web.index.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pureboyz.studymap.mapper.user.UserMapper;

/**
 * <pre>
 * Date 		: 2019. 12. 8.
 * Author 		: pureboyz
 *
 * 
 * 
 * </pre>
 */
@Service("com.pureboyz.todolist.web.index.service.IndexService")
public class IndexService
{
	@Resource(name="com.pureboyz.todolist.mapper.user.UserMapper")
	UserMapper userMapper;

	/**
	 * <pre>
	 * MethodName 	: SelectUserByIdAndPassword
	 * Date 		: 2019. 12. 8.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: Map<String, String>
	 * ReturnType 	: List<Map<String,Object>>
	 *
	 * 사용자가 입력한 ID, PASSWORD로 USER TABLE에서 가입 여부 확인.
	 * 
	 * </pre>
	 */
	public Map<String, Object> SelectUserByIdAndPassword(Map<String, String> userMap)
	{
		return userMapper.SelectUserByIdAndPassword(userMap);
	}


}
