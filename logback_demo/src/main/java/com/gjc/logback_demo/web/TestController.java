package com.gjc.logback_demo.web;

import com.gjc.logback_demo.single.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private Test test;

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/test1")
    public void test1() {
        log.info("执行了方法：{}", "test1");
    }

    @RequestMapping("/test2")
    public void test2() {
        test.test();
    }
}
