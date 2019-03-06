package com.service;

import com.model.pojo.Student;

import java.util.List;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/21 0021 21:54
 * @Version 1.0
 **/
public interface StudentService {

    Student findById(Long id);

    List<Student> findAll();

    void insert(Student student);

    void update(Student student);

    void delete(Long id);




}
