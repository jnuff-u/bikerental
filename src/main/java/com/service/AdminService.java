package com.service;

import com.model.pojo.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdminService
 * @Description TODO
 * @Author ZQ
 * @Date 2019/3/4 0004 15:35
 **/
public interface AdminService {

    /**
     * 根据id查找用户
     *
     * @param id
     * @return com.model.pojo.Admin
     **/
    Admin findById(Long id);

    /**
     * 根据用户名查找用户
     *
     * @param userName
     * @return com.model.pojo.Admin
     **/
    Admin findByName(String userName);

    /**
     * 根据邮箱查找用户
     *
     * @param email
     * @return com.model.pojo.Admin
     **/
    Admin findByEmail(String email);

    /**
     * 查询所有用户
     *
     * @param
     * @return com.model.pojo.Admin
     **/
    List<Admin> findAll();

    /**
     * 添加用户
     *
     * @param admin
     * @return Long 新用户Id
     **/
    Long insert(Admin admin);


    /**
     * 修改用户
     *
     * @param admin
     * @return int
     **/
    int update(Admin admin);


    /**
     * 删除用户
     *
     * @param id
     * @return int
     **/
    int delete(Long id);

}
