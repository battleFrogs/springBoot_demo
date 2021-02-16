package com.gjc.mybatis_demo.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gjc.common.constant.ResultData;
import com.gjc.mybatis_demo.mapper.ResultMapper;
import com.gjc.mybatis_demo.mapper.StudentMapper;
import com.gjc.mybatis_demo.model.ResultInfo;
import com.gjc.mybatis_demo.model.Student;
import com.gjc.mybatis_demo.vo.StudentResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);


    @Resource
    private StudentMapper studentMapper;
    @Resource
    private ResultMapper resultMapper;

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
     * 注解形式保存
     *
     * @param student 学生结果
     * @return resultData
     */
    @PostMapping("/saveStudent")
    public ResultData saveStudent(Student student) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(),
                "成功");
        student.setCreated(new Date());
        boolean b = studentMapper.saveStudent(student);
        log.info("保存状态：{}", b);
        log.info("学生：{}", student);
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


    /**
     * 通过名称查询 分页
     * 分开返回结果
     *
     * @param pageIndex 当前页
     * @param pageSize  每页条数
     * @return resultData
     */
    @GetMapping("/getStudentByNamePage")
    public ResultData getStudentByNamePage(Integer pageIndex, Integer pageSize) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(),
                "成功");
        PageHelper.startPage(pageIndex, pageSize);
        Page<Student> query = studentMapper.query();
        resultData.addData("result", query);
        resultData.addData("total", query.getTotal());
        return resultData;
    }

    /**
     * 获取分页结果 通过pageInfo包装
     *
     * @param pageIndex 当前页
     * @param pageSize  每页条数
     * @return resultData
     */
    @GetMapping("/getStudentByNamePageInfo")
    public ResultData getStudentByNamePageInfo(Integer pageIndex, Integer pageSize) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(),
                "成功");

        PageHelper.startPage(pageIndex, pageSize);
        List<Student> students = studentMapper.queryList();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        resultData.addData("result", pageInfo);
        return resultData;
    }


    /**
     * 获取连表集合数据
     *
     * @return resultData
     */
    @GetMapping("/getPojoList")
    public ResultData getPojoList() {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(),
                "成功");
        StudentResult resultList = studentMapper.getResultList();
        resultData.addData("result", resultList);
        return resultData;
    }


    /**
     * 保存结果集
     *
     * @param resultInfo 结果集
     * @return resultData
     */
    @GetMapping("/saveResult")
    public ResultData saveResult(ResultInfo resultInfo) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(),
                "成功");
        boolean b = resultMapper.saveResult(resultInfo);
        log.info("保存状态：{}", b);
        log.info("结果：{}", resultInfo);

        return resultData;
    }


    /**
     * 通过ids删除列表
     *
     * @param ids id集合列表
     * @return resultData 结果集
     */
    @GetMapping("/deleteByIds")
    public ResultData deleteByIds(@RequestParam("ids") List<Long> ids) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(),
                "成功");
        boolean b = resultMapper.deleteResult(ids);
        log.info("保存状态：{}", b);
        return resultData;
    }

    /**
     * 通过名称模糊查询
     *
     * @param name 结果
     * @return resultData
     */
    @GetMapping("/selectResultByName")
    public ResultData selectResultByName(String name) {
        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(),
                "成功");
        List<ResultInfo> resultInfos = resultMapper.selectResultInfoList(name);
        resultData.addData("result", resultInfos);
        return resultData;
    }
}
