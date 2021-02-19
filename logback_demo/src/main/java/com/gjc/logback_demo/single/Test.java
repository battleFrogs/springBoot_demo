package com.gjc.logback_demo.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Test {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public void test() {
        log.info("执行Test类 的 test方法");
    }


}
