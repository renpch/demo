package com.example.demo.controller;

import com.example.demo.dto.ScoreDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentCourse;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentCourseService;
import com.example.demo.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.transaction.TransactionProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 注解 @RestController表示这是一个控制器类
@RestController
public class TestController {

    @Resource
    private StudentService studentService;


    @Resource
    private CourseService courseService;

    @Resource
    private StudentCourseService studentCourseService;

    @Resource
    private StudentMapper studentMapper;
    @Autowired
    private TransactionProperties transactionProperties;


    // 注解 @GetMapping表示这是一个处理GET请求的方法
    @GetMapping("/test")
    public List<Student> test() {
        // 调用StudentService的getAll方法
        List<Student> studentList = studentService.getAll();
        return studentList;

//        return studentMapper.selectAll();
    }

    @GetMapping("/test2")
    public List<Course> test2() {
        // 调用StudentService的getAll方法
        List<Course> courseList = courseService.getAll();
        return courseList;


    }

    @GetMapping("/test3")
    public Double test3() {
        // 调用StudentService的getAll方法
        List<StudentCourse> studentCourseList = studentCourseService.getAll();
        Double sum = 0.0;
        for (StudentCourse studentCourse : studentCourseList) {
            sum = sum + studentCourse.getScore();
        }
        Double avg = sum / studentCourseList.size();
        System.out.println(avg);
//        System.out.println();
        return avg;


    }


//@GetMapping("/test4")
//public List<ScoreDto> test4(@RequestParam(value = "name")String studentName) {
//    // 调用StudentService的getAll方法
//    List<StudentCourse> studentCourseList = studentCourseService.getAll();
//    List<Student> studentList = studentService.getAll();
//    List<Course> courseList = courseService.getAll();
//
//    // 初始化学生ID变量
//    String studentId = "";
//
//    // 遍历学生列表，寻找与参数匹配的学生姓名，获取对应学生ID
//    for (Student student : studentList){
//        if (student.getStudentName().equals(studentName)){
//            studentId = student.getStudentId();
//        }
//    }
//
//    // 输出学生ID用于调试
//    System.out.println(studentId);
//
//    // 初始化存储特定学生课程成绩的列表
//    List<StudentCourse> studentCourseList1 = new ArrayList<>();
//    // 遍历所有学生课程，筛选出特定学生的课程成绩
//    for (StudentCourse studentCourse : studentCourseList){
//        if (studentCourse.getStudentId().equals(studentId)){
//            studentCourseList1.add(studentCourse);
//        }
//    }
//
//    // 初始化DTO列表，用于存储转换后的学生成绩信息
//    List<ScoreDto> dtolist = new ArrayList<>();
//    // 遍历特定学生的课程成绩列表，构建ScoreDto对象
//    for (StudentCourse studentCourse : studentCourseList1){
//        ScoreDto scoreDto = new ScoreDto();
//        // 遍历课程列表，获取课程名称
//        for (Course course : courseList){
//            if (studentCourse.getCourseId().equals(course.getCourseId())){
//                scoreDto.setCourseName(course.getCourseName());
//            }
//        }
//        // 设置成绩并添加到DTO列表
//        scoreDto.setScore(studentCourse.getScore());
//        dtolist.add(scoreDto);
//    }
//
//    // 返回学生成绩DTO列表
//    return dtolist;
//
//}
//}
//@GetMapping("/test5")
//public List<ScoreDto> getScoresBySubject(@RequestParam(value = "courseName") String courseName) {
//    // 获取所有学生课程成绩
//    List<StudentCourse> studentCourseList = studentCourseService.getAll();
//    // 获取所有课程
//    List<Course> courseList = courseService.getAll();
//
//    // 初始化存储特定科目课程ID的变量
//    String courseId = "";
//
//    // 遍历课程列表，寻找与参数匹配的课程名称，获取对应课程ID
//    for (Course course : courseList) {
//        if (course.getCourseName().equals(courseName)) {
//            courseId = course.getCourseId();
//        }
//    }
//
//    // 输出课程ID用于调试
//    System.out.println("Course ID: " + courseId);
//
//    // 初始化存储特定科目课程成绩的列表
//    List<StudentCourse> filteredStudentCourseList = new ArrayList<>();
//
//    // 遍历所有学生课程，筛选出特定科目的课程成绩
//    for (StudentCourse studentCourse : studentCourseList) {
//        if (studentCourse.getCourseId().equals(courseId)) {
//            filteredStudentCourseList.add(studentCourse);
//        }
//    }
//
//    // 初始化DTO列表，用于存储转换后的学生成绩信息
//    List<ScoreDto> dtolist = new ArrayList<>();
//
//    // 遍历特定科目的课程成绩列表，构建ScoreDto对象
//    for (StudentCourse studentCourse : filteredStudentCourseList) {
//        ScoreDto scoreDto = new ScoreDto();
//        scoreDto.setStudentId(studentCourse.getStudentId());
////        scoreDto.setCourseName(Course.getCourseName);
//        scoreDto.setScore(studentCourse.getScore());
//        dtolist.add(scoreDto);
//    }
//
//    // 返回学生成绩DTO列表
//    return dtolist;
//}
//
//}

    @GetMapping("/test5")
    public List<ScoreDto> getScoresBySubject(@RequestParam(value = "courseName") String courseName) {
        // 获取所有学生课程成绩
        List<StudentCourse> studentCourseList = studentCourseService.getAll();
        // 获取所有课程
        List<Course> courseList = courseService.getAll();

        // 构建课程名到课程 ID 的映射
        Map<String, String> courseNameToIdMap = courseList.stream()
                .collect(Collectors.toMap(Course::getCourseName, Course::getCourseId));

        // 获取课程 ID，若找不到则返回空列表
        String courseId = courseNameToIdMap.get(courseName);
        if (courseId == null) {
            System.out.println("Course not found: " + courseName);
            return new ArrayList<>();
        }

        // 筛选出特定课程 ID 的学生成绩
        List<StudentCourse> filteredStudentCourseList = studentCourseList.stream()
                .filter(studentCourse -> courseId.equals(studentCourse.getCourseId()))
                .collect(Collectors.toList());

        // 构建 DTO 列表，包含学生姓名
        List<ScoreDto> dtolist = filteredStudentCourseList.stream()
                .map(studentCourse -> {
                    ScoreDto scoreDto = new ScoreDto();
//                    scoreDto.setStudentId(studentCourse.getStudentId());
                    scoreDto.setStudentId(studentCourse.getStudentId() != null ? studentCourse.getStudentId() : "0");
//                    scoreDto.setCourseName(courseName); // 设置课程名称
                    scoreDto.setScore(studentCourse.getScore());

                    // 获取学生姓名并设置
                    Student student = studentService.getStudentById(studentCourse.getStudentId());
                    if (student != null) {
                        scoreDto.setStudentName(student.getStudentName());
                    } else {
                        scoreDto.setStudentName("Unknown"); // 若找不到学生，设置默认值
                    }

                    return scoreDto;
                })
                .collect(Collectors.toList());

        return dtolist;
    }
}


//    @GetMapping("/test4")
//    public List<ScoreDto> test4(@RequestParam(value = "name")String studentName) {
//        // 调用StudentService的getAll方法
//        List<StudentCourse> studentCourseList = studentCourseService.getAll();
//        List<Student> studentList = studentService.getAll();
//        List<Course> courseList = courseService.getAll();
//
////        String studentName = "彭万里";
//        String studentId = "";
//
//        for (Student student : studentList){
//            if (student.getStudentName().equals(studentName)){
//                studentId = student.getStudentId();
//            }
//        }/**
// * 获取学生测试成绩
// *
// * @param studentName 学生姓名
// * @return 学生成绩列表
// */
//        // 获取学生成绩
//        System.out.println(studentId);
//        List<StudentCourse> studentCourseList1 = new ArrayList<>();
//        for (StudentCourse studentCourse : studentCourseList){
//            if (studentCourse.getStudentId().equals(studentId)){
////                System.out.println(studentCourse.getScore());
//                studentCourseList1.add(studentCourse);
//            }
//        }
//        List<ScoreDto> dtolist = new ArrayList<>();
//        for (StudentCourse studentCourse : studentCourseList1){
//            ScoreDto scoreDto = new ScoreDto();
//            for (Course course : courseList){
//                if (studentCourse.getCourseId().equals(course.getCourseId())){
//                    scoreDto.setCourseName(course.getCourseName());
//                }
//            }
//            scoreDto.setScore(studentCourse.getScore());
//            dtolist.add(scoreDto);
//        }
//        return dtolist;
//
//        Double sum = 0.0;
//        for (StudentCourse studentCourse : studentCourseList){
//            sum = sum + studentCourse.getScore();
//        }
//        Double avg = sum / studentCourseList.size();
//        System.out.println(avg);
////        System.out.println();
//        return avg;


//
//    }
//    // 获取学生的成绩
//
//}
