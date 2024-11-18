package com.example.demo.service.impl;

import com.example.demo.entity.StudentCourse;
import com.example.demo.mapper.StudentCourseMapper;
import com.example.demo.service.StudentCourseService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@ComponentScan("com.example.demo")
@Service("studentCourseService")
public class StudentCourseServiceImpl implements StudentCourseService {

    @Resource
    private StudentCourseMapper studentCourseMapper;


    @Override
    public List<StudentCourse> getAll() {
        return studentCourseMapper.selectAll();
    }
}
