package com.gjc.mybatis_demo.web;

import com.gjc.common.constant.ResultData;
import com.gjc.mybatis_demo.mapper.StudentMapper;
import com.gjc.mybatis_demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private StudentMapper studentMapper;

    /**
     * 保存结果
     *
     * @param student 参数
     * @return resultData
     */
    @PostMapping("/save")
    public ResultData save(Student student) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(),
                "成功");
        student.setCreated(new Date());
        studentMapper.insert(student);
        return resultData;
    }

    /**
     * 通过名称查询
     *
     * @param name 名称
     * @return resultData
     */
    @GetMapping("/getStudentByName")
    public ResultData getStudentByName(String name) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(),
                "成功");
        List<Student> result = studentMapper.findByUsername(name);
        resultData.addData("result", result);
        return resultData;
    }


}
