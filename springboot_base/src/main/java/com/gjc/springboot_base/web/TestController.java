package com.gjc.springboot_base.web;

import com.gjc.springboot_base.bean.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${student.name}")
    private String name;

    @Value("${student.age}")
    private String age;

    @Resource
    private Teacher teacher;

    /**
     * 获取配置里的age和name属性
     */
    @RequestMapping("/test")
    public void test() {
        log.info("name: {} ,age: {}", name, age);
    }


    /**
     * 获取配置里的teacher
     */
    @RequestMapping("/test2")
    public void test2() {
        log.info("teacher : teach - {} , school -{} ", teacher.getTeach(), teacher.getSchool());
    }
}
