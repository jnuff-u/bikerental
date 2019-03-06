package com.model.enums;

/**
 * @ClassName ResultCodeEnum
 * @Description TODO 返回结果 Enum
 * @Author ZhangQiang
 * @Date 2019/2/26 0026 17:16
 * @Version 1.0
 **/
public enum  ResultCodeEnum {

    /**
    * 失败：0
    */
    FAIL(0),

    /**
     * 成功：1
     */
    SUCCESS(1);

    Integer statCode;

    ResultCodeEnum(Integer statCode){
        this.statCode = statCode;
    }

    public Integer getStatCode(){
        return statCode;
    }


}
