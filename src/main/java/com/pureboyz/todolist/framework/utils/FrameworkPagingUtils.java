package com.pureboyz.todolist.framework.utils;

import java.util.List;

import com.pureboyz.todolist.framework.beans.BasicBean;
import com.pureboyz.todolist.framework.mymap.MyCamelMap;
import com.pureboyz.todolist.framework.mymap.MyMap;
import com.pureboyz.todolist.framework.pagination.PaginationInfo;

public class FrameworkPagingUtils
{
    public static void pagingRange(MyMap paramMap, int iRecordCountPerPage)
    {
        PaginationInfo   paginationInfo   = new PaginationInfo();
        paginationInfo.setCurrentPageNo(paramMap.getInt("page", 1));
        paginationInfo.setRecordCountPerPage(paramMap.getInt("rows", iRecordCountPerPage));

        paramMap.put("start", paginationInfo.getFirstRecordIndex());
        paramMap.put("end",   paginationInfo.getRecordCountPerPage());
    }

    public static BasicBean pagingData(MyMap paramMap, int iRecordCountPerPage, int iToatal, List<MyCamelMap> dataList)
    {
        PaginationInfo   paginationInfo   = new PaginationInfo();
        BasicBean        bean             = new BasicBean();

        paginationInfo.setCurrentPageNo(paramMap.getInt("page", 1));
        paginationInfo.setRecordCountPerPage(paramMap.getInt("rows", iRecordCountPerPage));

        paginationInfo.setTotalRecordCount(iToatal);

        bean.setList(dataList);
        bean.setPaginationInfo(paginationInfo);

        return bean;
    }
}
