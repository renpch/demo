package com.example.demo.dto;

import lombok.Data;

@Data
public class ScoreDto {

//    private String courseName;
    private String studentName;

    private Double score;

    private String studentId;

    public void setStudentId(String studentId) {
    }
}
