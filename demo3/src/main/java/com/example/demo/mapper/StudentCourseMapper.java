package com.example.demo.mapper;

import com.example.demo.entity.StudentCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentCourseMapper {

//    int deleteByPrimaryKey(Long id);
//
//    int insert(Student record);
//
////    int insertSelective(Student record);
//
//    Student selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(Student record);
//
//    int updateByPrimaryKey(Student record);

    List<StudentCourse> selectAll();

}
