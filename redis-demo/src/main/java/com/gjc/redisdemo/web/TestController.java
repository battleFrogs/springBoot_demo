package com.gjc.redisdemo.web;

import com.gjc.common.constant.ResultData;
import com.gjc.redisdemo.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RedisUtils redisUtils;

    @GetMapping("set")
    public ResultData testSet(String name, String value) {
        redisUtils.set(name, value);
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }

    @GetMapping("/get")
    public ResultData testGet(String name) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
        Object o = redisUtils.get(name);
        resultData.addData("result", o);
        return resultData;
    }


}
