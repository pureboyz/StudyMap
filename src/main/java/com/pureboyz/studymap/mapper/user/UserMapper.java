package com.pureboyz.studymap.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pureboyz.studymap.framework.mymap.MyCamelMap;
import com.pureboyz.studymap.framework.mymap.MyMap;

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
@Repository("com.pureboyz.studymap.mapper.user.UserMapper")
public interface UserMapper
{

	MyCamelMap SelectUserByIdAndPassword(MyMap paramMap);

}
