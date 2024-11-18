package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

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

    List<Student> selectAll();

    Student selectById(String studentId); // 根据学生ID查询

}
