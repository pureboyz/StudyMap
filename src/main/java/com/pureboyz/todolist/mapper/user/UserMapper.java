package com.pureboyz.todolist.mapper.user;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Date 		: 2019. 12. 8.
 * Author 		: pureboyz
 *
 * User Table에 대한 쿼리 담당.
 * 
 * </pre>
 */
@Mapper
@Repository("com.pureboyz.todolist.mapper.user.UserMapper")
public interface UserMapper
{

	Map<String, Object> SelectUserByIdAndPassword(Map<String, String> userMap);

}
