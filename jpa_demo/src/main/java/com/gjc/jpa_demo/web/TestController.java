package com.gjc.jpa_demo.web;

import com.gjc.jpa_demo.dao.StudentRepository;
import com.gjc.jpa_demo.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private StudentRepository studentRepository;

    @RequestMapping("/test")
    public void test(Student student) {
        studentRepository.save(student);
    }
}
