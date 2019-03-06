package com.model.enums;

/**
 * @ClassName LocaleEnum
 * @Description TODO
 * @Author ZQ
 * @Date 2019/3/5 0005 0:54
 **/
public enum LocaleEnum {

        EN_US("en_US"),

        ZH_CN("zh_CN");

        private String value;

        LocaleEnum(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }



}
