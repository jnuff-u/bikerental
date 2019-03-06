package com.service.impl;

import com.model.pojo.Student;
import com.repository.StudentRepository;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/21 0021 21:54
 * @Version 1.0
 **/
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public Student findById(Long id) {

        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Override
    public void insert(Student student) {
         studentRepository.insert(student);
    }
        
    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }
}
