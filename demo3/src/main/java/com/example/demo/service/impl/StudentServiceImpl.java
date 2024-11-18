package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@ComponentScan("com.example.demo")
//@Service("studentService")
//public class StudentServiceImpl implements StudentService {
//
//    @Resource
//    private StudentMapper studentMapper;
//
//
//    @Override
//    public List<Student> getAll() {
//        return studentMapper.selectAll();
//    }
//}

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAll() {
        return studentMapper.selectAll();
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentMapper.selectById(studentId);
    }
}