package com.model.dto;

import lombok.Data;

/**
 * @ClassName JsonResult
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/26 0026 16:56
 * @Version 1.0
 **/
@Data
public class JsonResult {

    /***
     * @Description //TODO 状态码 1：失败 0：成功
     *
     **/
    private Integer stat;

    /**
     * @Description //TODO 结果代码 （404.500.200...）
     *
     **/
    private Integer code;

    /***
     * @Description //TODO 文本信息
     *
     **/
    private String msg;

    /**
     * @Description //TODO 结果对象（返回数据）
     *
     **/
    private Object result;


    public JsonResult() { }

    /***
     * @Description //TODO 只返回状态码
     * @Date 17:10 2019/2/26 0026
     *
     **/
    public JsonResult(Integer stat){
        this.stat = stat;
    }

    /***
     * @Description //TODO 不返回数据
     * @Date 17:10 2019/2/26 0026
     *
     **/
    public JsonResult(Integer stat, Integer code, String msg) {
        this.stat = stat;
        this.code = code;
        this.msg = msg;
    }

    /**
     * @Description //TODO 返回状态码和数据
     * @Date 17:13 2019/2/26 0026
     *
     **/
    public JsonResult(Integer stat, Object result){
        this.stat = stat;
        this.result = result;
    }

    /**
     * @Description //TODO 返回状态码和信息（成功/失败，信息）
     * @Date 16:23 2019/3/4 0004
     * @Param [statCode, msg]
     * @return
     **/
    public JsonResult(Integer stat, String msg){

        this.stat = stat;
        this.msg = msg;
    }


    /**
     * @Description //TODO 返回所有信息
     * @Date 17:12 2019/2/26 0026
     *
     **/
    public JsonResult(Integer stat, Integer code, String msg, Object result){
        this.stat = stat;
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

}
