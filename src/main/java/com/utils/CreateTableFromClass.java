package com.utils;


import com.model.pojo.Common;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CreateTableFromClass
 * @Description TODO
 * @Author ZhangQiang // Administrator
 * @Date 2019/1/29 0029 18:47
 * @Version 1.0
 **/
public class CreateTableFromClass {

    public static Map<String,String> javaProperty2SqlColumnMap = new HashMap<>();

    static {

        javaProperty2SqlColumnMap.put( "Integer" , "INTEGER");
        javaProperty2SqlColumnMap.put( "Short" , "tinyint");
        javaProperty2SqlColumnMap.put( "Long" , "bigint");
        javaProperty2SqlColumnMap.put( "BigDecimal" , "decimal(19,2)");
        javaProperty2SqlColumnMap.put( "Double" , "double precision not null");
        javaProperty2SqlColumnMap.put( "Float" , "float");
        javaProperty2SqlColumnMap.put( "Boolean" , "bit");
        javaProperty2SqlColumnMap.put( "Timestamp" , "datetime");
        javaProperty2SqlColumnMap.put( "String" , "VARCHAR(255)");

    }

    public static void main(String[] args) throws IOException {
        createTable(Common.class);
    }


    public static String createTable(Class obj) throws IOException {

        String tableName = obj.getName();

        tableName = tableName.substring(tableName.lastIndexOf(".") + 1);

        System.out.println(" table Name :" + tableName);

        return createTable(obj,tableName);
    }

    public static String createTable(Class obj,String tableName) throws IOException{

        //获取所有对象属性
        Field[] fields = obj.getDeclaredFields();

        String param = null;
        String colume = null;

        StringBuilder sb = new StringBuilder(255);

        if (tableName == null || tableName.equals("")) {
            tableName = obj.getName();
            tableName = tableName.substring(tableName.lastIndexOf(".") + 1);

            System.out.println(tableName);
        }

        sb.append("create table ").append(tableName).append("( \r\n ");

        System.out.println(sb.toString());

        boolean firstId = true;
        int i = 0;
        for(Field f:fields){

            colume = f.getName();

            System.out.println("fields [" + i + "]: " + fields[i]);
            System.out.println(" \r fields [" + i + "]: " + colume);

            i++;

            if (colume.equals("serialVersionUID")){
                continue;
            }

            // _ 驼峰替换 首字母不要大写
            StringBuilder sbcol = new StringBuilder(colume);
            for (int j=0;j< colume.length();j++){
                char c = colume.charAt(j);
                if (Character.isUpperCase(c)){
                    // 注意特殊变量名，比如QRCode ——  ___cRCode 这类转换时需要注意
                    sbcol.replace(j,j+1,"_"+Character.toLowerCase(c));
                }
            }

            colume = sbcol.toString();
            System.out.println(" colume:" + colume);

            param = f.getType().getSimpleName();
            sb.append(colume);
            sb.append(" ").append(javaProperty2SqlColumnMap.get(param)).append(" ");

            if (firstId){
                sb.append("PRIMARY KEY AUTO_INCREMENT");
                firstId = false;
            }

            sb.append(" , \n ");

        }
            String sql = sb.toString();

            int lastIndex = sql.lastIndexOf(",");

            sql = sql.substring(0,lastIndex) + sql.substring(lastIndex + 1);

            sql = sql.substring(0,sql.length()-1) + " ) ENGINE = INNODB DEFAULT CHARSET = UTF8; \r\n ";

            System.out.println(" sql : " + sql);

            return sql;

    }











}
