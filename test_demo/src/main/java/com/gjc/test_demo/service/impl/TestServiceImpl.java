package com.gjc.test_demo.service.impl;

import com.gjc.test_demo.entity.Student;
import com.gjc.test_demo.service.StudentService;
import com.gjc.test_demo.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private StudentService studentService;

    @Override
    public String test(Long id) {
        Student stu = studentService.lambdaQuery().eq(Student::getId, id).one();
        return stu.getName();
    }


    @Override
    public String testAgain(Long id) {
        Student student = studentService.getStudentById(id);
        return student.getName();
    }


}
