package com.example.demo.service;


import com.example.demo.entity.Student;

import java.util.List;


public interface StudentService {
    // 获取所有学生
    List<Student> getAll();

    // 根据学生ID获取学生信息
    Student getStudentById(String studentId);
}