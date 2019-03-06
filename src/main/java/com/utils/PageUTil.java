package com.utils;

import com.model.dto.Page;

import java.util.*;

/**
 * @ClassName PageUTil
 * @Description TODO 分页工具
 * @Author ZhangQiang
 * @Date 2019/2/27 0027 16:15
 * @Version 1.0
 **/
public class PageUTil<T> {

    public Page<T> getPage(List dataList) {
        return getPage(0,5, dataList);
    }

    /**
     * @Description //TODO 数据量少 取所有数据分页 dataList为全部数据
     * @Date 16:53 2019/2/27 0027
     *
     **/
    public Page<T> getPage(int nowPage, int pageSize, List<T> dataList){

        Page<T> page = new Page();
        List<T> pageList = dataList;

        /*总数据*/
        int totalCount = dataList.size();

        /*总页数( (totalCount + pageSize - 1 ) / pageSize ，判断是否多出小于一页的数据，多出则+1页)*/
        int totalPage = (totalCount + pageSize - 1) / pageSize;

        /*当前页*/
        page.setNowPage(nowPage);

        /*当前分页数据*/
        int fromIndex = (nowPage - 1) * pageSize;
        int toIndex = nowPage * pageSize;

        if (fromIndex >= dataList.size() && fromIndex < 0) pageList = Collections.emptyList();
        if (toIndex >= dataList.size()) toIndex = dataList.size();
        System.out.println("当前页 nowPage：" + nowPage + " " + "从 " + fromIndex + " 到 " + toIndex);
        /*截取分页数据*/
        System.out.println(" 分页数据 ： " + pageList.size() + "条");
        page.setDataList(pageList.subList(fromIndex,toIndex));

        /*每页数据量*/
        page.setPageSize(pageSize);
        /*总数据量*/
        page.setTotalConut(totalCount);
        /*总页数*/
        page.setTotalPage(totalPage);

        return page;
    }

    public Page<T> getPageLimit(int totalCount){
        return getPageLimit(0,5,totalCount);
    }

    /**
     * @Description //TODO 数据量多 取每页数据分页
     * @Date 17:12 2019/2/27 0027
     * @Param totalCount 所有数据总数据量count(0)
     * @return
     **/
    public Page<T> getPageLimit(int nowPage, int pageSize, int totalCount){

        Page<T> page = new Page();

        /*查询开始页*/
        int start = (nowPage-1) * pageSize;
        page.setStart(start);

        /*当前页*/
        page.setNowPage(nowPage);

        /*每页多少条数据*/
        page.setPageSize(pageSize);

        /*总多少条数据*/
        page.setTotalConut(totalCount);

        /*总多少页 向上取整*/
        Double totalP = Math.ceil((double)totalCount/pageSize);
        page.setTotalPage(totalP.intValue());

        /* sql limit start,pageSize*/
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("start",start);
        map.put("size",pageSize);

        return page;
        
    }


}
