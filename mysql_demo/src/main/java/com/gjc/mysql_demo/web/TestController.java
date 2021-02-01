package com.gjc.mysql_demo.web;


import com.gjc.common.constant.ResultData;
import com.gjc.mysql_demo.dao.TestDao;
import com.gjc.mysql_demo.entity.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TestDao testDao;

    @GetMapping
    public ResultData findAll() {
        ResultData resultData = new ResultData(ResultData.ResultEnum.ERROR.getCode(), "成功");
        List<Test> result = testDao.findAll();
        log.info("结果：{}", result);
        resultData.addData("result", result);
        resultData.setCode(ResultData.ResultEnum.SUCCESS.getCode());
        return resultData;
    }

    @DeleteMapping("{id}")
    public ResultData deleteById(@PathVariable("id") String id) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.ERROR.getCode(), "成功");
        testDao.delete(id);
        resultData.setCode(ResultData.ResultEnum.SUCCESS.getCode());
        return resultData;
    }

    @PostMapping
    public ResultData save(@RequestBody Test test) {
        testDao.save(test);
        return new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
    }

}

