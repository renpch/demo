package com.example.demo.mapper;

import com.example.demo.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

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

    List<Course> selectAll();

}
