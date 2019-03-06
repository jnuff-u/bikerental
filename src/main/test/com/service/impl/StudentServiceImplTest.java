package com.service.impl;

import com.model.pojo.Student;
import com.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:application.xml")
public class StudentServiceImplTest {
    private static Logger logger = LogManager.getLogger(StudentServiceImplTest.class);
    @Autowired
    StudentService studentService;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void findById() throws Exception {
    }

    @Test
    @Transactional(readOnly = false)
    @Rollback(value = false)
    public void insert() throws Exception {

        Student student = new Student();

        student.setCreateAt(new Date());
        student.setUpdateAt(new Date());
        student.setCreateBy(1L);
        student.setUpdateBy(1L);
        student.setEmail("test222@163.com");
        student.setStudentNum("082222123");
        student.setPassword("5552222");
        student.setTell("886");
        student.setUsername("LiLei");

        studentService.insert(student);

    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}