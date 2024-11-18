package com.example.demo.entity;


import lombok.Data;

@Data
public class StudentCourse {

    private Long id;

    private String studentId;

    private String courseId;

    private Double score;

    public String getStudentName() {
        return "";
    }
}
