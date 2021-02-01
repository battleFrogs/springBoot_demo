package com.gjc.spring_security_demo.controller;

import com.gjc.common.constant.ResultData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public ResultData test() {
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }
}
