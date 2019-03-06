package com.service.impl;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import com.model.pojo.Admin;
import com.service.AdminService;
import com.utils.HqlUtil;
import com.utils.SecurityUtil;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:application.xml")
public class AdminServiceImplTest {


    @Autowired
    AdminService adminService;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    HqlUtil hqlUtil;

    @Test
    public void findById() throws Exception {
    }

    @Test
    @Transactional(readOnly = false)
    @Rollback(value = false)
    public void findByName() throws Exception {

//        Admin admin = adminService.findByEmail("");
        Admin admin = adminService.findByName("admin");
        System.out.println("admin isEmpty : " + (admin == null));
        System.out.println("admin:" + admin);

        String m = DigestUtil.md5Hex("test" + SecurityUtil.getSult()).toString();

        System.out.println(m);
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    @Transactional(readOnly = false)
    @Rollback(value = false)
    public void insert() throws Exception {

        Admin admin = new Admin();
        admin.setUsername("测试");
        admin.setCreateAt(new Date());
        admin.setUpdateAt(new Date());

        Long s = adminService.insert(admin);
        System.out.println("插入的id为 :" + s);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}