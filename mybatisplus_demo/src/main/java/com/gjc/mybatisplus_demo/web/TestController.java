package com.gjc.mybatisplus_demo.web;

import com.gjc.mybatisplus_demo.entity.Test;
import com.gjc.mybatisplus_demo.mapper.TestMapper;
import com.gjc.mybatisplus_demo.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {


    @Resource
    private TestService testService;

    @Resource
    private TestMapper testMapper;

    @RequestMapping("/test")
    public void test() {

        Test test = testService.lambdaQuery().list().get(0);
        Test test1 = testMapper.selectById(2);
        System.out.println(test);
        System.out.println(test1);

    }

}
