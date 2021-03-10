package com.gjc.springboot_base.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 静态注入  , @Value 修饰在方法上
 */
@Component
public class Student {


    public static Integer age;
    public static String name;

    @Value("${student.age}")
    public Student setAge(Integer age) {
        age = age;
        return this;
    }

    @Value("${student.name}")
    public Student setName(String name) {
        name = name;
        return this;
    }
}
