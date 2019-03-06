package com.model.enums;

/**
 * @ClassName OptionEnum
 * @Description TODO
 * @Author ZQ
 * @Date 2019/3/5 0005 1:04
 **/
public enum OptionEnum {

    LANGUAGE("local"),

    TITLE("title"),

    HOME_URL("home_url");

    private String option;

    OptionEnum(String option){
        this.option = option;
    }

    public String getOption(){
        return option;
    }

}
