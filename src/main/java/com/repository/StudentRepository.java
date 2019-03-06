package com.repository;

import com.model.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName StudentRepository
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/21 0021 21:52
 * @Version 1.0
 **/
@Repository
public interface StudentRepository {

    Student findById(Long id);


    List<Student> findAll();


    void insert(Student student);

    void update(Student student);

    void delete(Long id);

}
