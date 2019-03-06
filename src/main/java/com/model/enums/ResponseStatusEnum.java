package com.model.enums;

import javax.persistence.Enumerated;

/**
 * @ClassName ResponseStatusEnum
 * @Description TODO 请求响应 Enum
 * @Author ZQ
 * @Date 2019/3/4 0004 16:27
 **/
public enum ResponseStatusEnum {

    /**
     * 请求成功
     * */
    SUCCESS(200,"SUCCESS"),

    /**
     * 资源为空
     * */
    EMPTY(204,"No Content"),

    /**
     * 服务器内部错误
     * */
    ERROR(500,"Internal Server Error"),

    /**
     * 资源未找到
     * */
    NOTFOUND(404,"Not Found");

    private Integer code;
    private String msg;

    ResponseStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

}
