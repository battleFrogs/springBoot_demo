package com.gjc.test_demo.mapper;

import com.gjc.test_demo.TestDemoApplication;
import com.gjc.test_demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("persistence")
@SpringBootTest(classes = TestDemoApplication.class)
public class StudentMapperTest {


    @Resource
    private StudentMapper studentMapper;

    @Test
    public void test() {
        Student student = studentMapper.selectById(1);
        System.out.println(student);
    }


}