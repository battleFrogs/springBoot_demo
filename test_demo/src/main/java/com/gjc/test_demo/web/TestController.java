package com.gjc.test_demo.web;

import com.alibaba.fastjson.JSONObject;
import com.gjc.common.constant.ResultData;
import com.gjc.test_demo.param.PostTestParam;
import com.gjc.test_demo.service.TestService;
import com.gjc.test_demo.vo.PostTestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class TestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Resource
    private TestService testService;

    /**
     * get  请求
     *
     * @param name 名称
     * @return resultData
     */
    @GetMapping("/getTest")
    public ResultData getTest(@RequestParam String name) {
        log.info("名称：{}", name);
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }


    /**
     * post json请求
     *
     * @param param 参数
     * @return resultData
     */
    @PostMapping("/postTest")
    public ResultData postTest(@RequestBody PostTestParam param) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
        log.info("名称：{} ， 年龄 ： {}", param.getName(), param.getAge());
        PostTestVo result = new PostTestVo();
        result.setAddName(param.getName() + "加上");
        result.setAddAge(param.getAge() + 1);
        resultData.setData(JSONObject.parseObject(JSONObject.toJSONString(result), Map.class));
        return resultData;
    }


    /**
     * 获取数据库数据的请求
     *
     * @param id 主键Id
     * @return resultData
     */
    @PostMapping("/postDetailTest")
    public ResultData postDetailTest(Long id) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
        String result = testService.test(id);
        resultData.addData("result", result);
        return resultData;
    }
}
