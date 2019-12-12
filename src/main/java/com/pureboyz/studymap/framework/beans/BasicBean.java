package com.pureboyz.studymap.framework.beans;

import java.util.List;

import com.pureboyz.studymap.framework.mymap.MyCamelMap;
import com.pureboyz.studymap.framework.mymap.MyMap;

public class BasicBean
{
    private MyMap               paramMap;
    private List<MyCamelMap>    list;

    public MyMap                getParamMap()           { return paramMap; }
    public List<MyCamelMap>     getList()               { return list; }

    public void setParamMap(MyMap paramMap)                      { this.paramMap = paramMap; }
    public void setList(List<MyCamelMap> list)                   { this.list = list; }
}
