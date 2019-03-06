package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description TODO
 * @Author
 * @Date 2019/2/26 0026 15:40
 * @Version 1.0
 **/
public class DateUtil {

    private Date date;

    public String getDateToString(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        return simpleDateFormat.format(new Date());

    }

    public String getDateToString(String format){

        if (format.equals("") && format==null) format = "yyyy-MM-dd hh:mm:ss";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        return simpleDateFormat.format(new Date());

    }



}
