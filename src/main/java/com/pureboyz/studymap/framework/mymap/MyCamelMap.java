package com.pureboyz.studymap.framework.mymap;

import org.apache.ibatis.type.Alias;

import com.pureboyz.studymap.framework.utils.FrameworkUtils;

@Alias("myCamelMap")
public class MyCamelMap extends MyMap
{
	private static final long serialVersionUID = -7776502858956301180L;

	public Object put(Object key,Object value)
	{
		return super.put(FrameworkUtils.convCamelCase((String)key),value);
	}
}