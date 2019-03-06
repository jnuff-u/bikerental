package com.model.dto;

import com.utils.SecurityUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Const
 * @Description TODO
 * @Author ZQ
 * @Date 2019/3/3 0003 11:25
 **/
public class Const {

    /**
     * 所有设置选项（key,value）
     */
    public static Map<String, String> OPTIONS = new HashMap<>();

    /**
     * USER_SESSION_KEY
     */
    public static final String USER_SESSION_KEY = SecurityUtil.getUserSessionKey();

    /**
     * sult 盐值
     */
    public static final String sult = SecurityUtil.getSult();



}
