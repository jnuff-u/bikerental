package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @ClassName SecurityUtil
 * @Description TODO
 * @Author
 * @Date 2019/2/22 0022 17:36
 * @Version 1.0
 **/
@Component
public class SecurityUtil {

    private static Logger log = LogManager.getLogger(SecurityUtil.class);

    private static final Properties PROPERTIES = new PropertiesUtil("config/security.properties").getProperties();

    public static String getSult(){
        return (String) PROPERTIES.get("user.salt");
    }

    public static String getUserSessionKey(){
        return (String) PROPERTIES.get("user.session.key");
    }


}
