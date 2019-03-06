package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @ClassName SqlUtil
 * @Description TODO
 * @Author ZQ
 * @Date 2019/3/4 0004 15:44
 **/
@Component
public class HqlUtil {

    private static Logger log = LogManager.getLogger(SecurityUtil.class);

    private static final Properties PROPERTIES = new PropertiesUtil("config/hql.properties").getProperties();

    public String getSql(String sqlKey){
        return (String) PROPERTIES.get(sqlKey);
    }


}
