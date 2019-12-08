package com.pureboyz.todolist.framework.mymap;

import com.pureboyz.todolist.framework.utils.FrameworkUtils;

public class MyCamelMap extends MyMap
{
	private static final long serialVersionUID = -7776502858956301180L;

	public Object put(Object key,Object value)
	{
		return super.put(FrameworkUtils.convCamelCase((String)key),value);
	}
}