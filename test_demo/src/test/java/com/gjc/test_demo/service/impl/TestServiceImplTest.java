package com.gjc.test_demo.service.impl;

import com.gjc.test_demo.entity.Student;
import com.gjc.test_demo.service.StudentService;
import com.gjc.test_demo.service.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Mockito.when;


public class TestServiceImplTest {


    @InjectMocks
    private TestService testService = new TestServiceImpl();

    @Mock
    private StudentService studentService;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);


    }

    @Test
    public void testAgain() {


        // mock service 返回数据
        Student student = new Student();
        student.setName("cgj");
        student.setCreated(new Date());
        student.setId(1L);


        when(studentService.getStudentById(Mockito.anyLong())).thenReturn(student);  // 指定mock掉dao层的数据


        String s = testService.testAgain(1L);
        Assertions.assertEquals(s, "cgj");

    }
}