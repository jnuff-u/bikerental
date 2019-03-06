package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName PropertiesUtil
 * @Description TODO
 * @Author ZQ
 * @Date 2019/3/4 0004 15:45
 **/
public class PropertiesUtil {

    private static Logger log = LogManager.getLogger(SecurityUtil.class);

    private static Properties properties = new Properties();

    public Properties getProperties(){
        return properties;
    }

    public PropertiesUtil(String ResourcePath){

        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(ResourcePath);

        try {

            properties.load(in);

        } catch (IOException e) {
            e.printStackTrace();
            log.error("读取properties文件出错");
        }
    }

//
//    public static Properties getProperties(String ResourcePath){
//
//        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(ResourcePath);
//
//        try {
//
//            properties.load(in);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            log.error("读取properties文件出错");
//        }
//
//        return properties;
//    }

}
