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
    public String test() {
        Student stu = studentService.lambdaQuery().eq(Student::getId, 1).one();
        return stu.getName();
    }


}
