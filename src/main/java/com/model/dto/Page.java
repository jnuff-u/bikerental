package com.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Page
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/27 0027 16:06
 * @Version 1.0
 **/
@Data
public class Page<T> {

    /**
     * @Description //TODO 数据
     * @Date 16:08 2019/2/27 0027
     *
     **/
    private List<T> dataList;
    /**
     * @Description //TODO 当前页
     * @Date 16:08 2019/2/27 0027
     *
     **/
    private int nowPage;
    /**
     * @Description //TODO 总页数
     * @Date 16:08 2019/2/27 0027
     *
     **/
    private int totalPage;

    /**
     * @Description //TODO 每页条数
     * @Date 16:09 2019/2/27 0027
     *
     **/
    private int pageSize;
    /**
     * @Description //TODO 总数据量
     * @Date 16:10 2019/2/27 0027
     *
     **/
    private int totalConut;
    
    /**
     * @Description //TODO 开始页（limite）
     * @Date 17:29 2019/2/27 0027
     * @Param 
     * @return          
     **/
    private int start;



}
