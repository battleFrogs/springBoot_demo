package com.gjc.interceptor_demo.web;

import com.gjc.common.constant.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping
    public ResultData requestTest() {

        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");

    }

    @RequestMapping("/loginIn")
    public ResultData loginIn() {
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }

}
