package com.gjc.mongodb_demo.web;

import com.gjc.common.constant.ResultData;
import com.gjc.mongodb_demo.dao.TestDao;
import com.gjc.mongodb_demo.entity.Test;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestDao testDao;

    @GetMapping("/findAll")
    public ResultData findAll() {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
        List<Test> all = testDao.findAll();
        resultData.addData("result", all);
        return resultData;
    }

    @PostMapping("/update")
    public ResultData update(@RequestBody Test test) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
        testDao.update(test);
        return resultData;
    }

    @GetMapping("/getOneById")
    public ResultData getOneById(Integer id) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
        Test oneById = testDao.getOneById(id);
        resultData.addData("result", oneById);
        return resultData;
    }


    @PostMapping("/save")
    public ResultData save(@RequestBody Test test) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
        testDao.save(test);
        return resultData;
    }






}
