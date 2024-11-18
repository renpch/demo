package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@ComponentScan("com.example.demo")
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;


    @Override
    public List<Course> getAll() {
        return courseMapper.selectAll();
    }
}
