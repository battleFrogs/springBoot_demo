package com.gjc.test_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.test_demo.entity.Student;
import com.gjc.test_demo.mapper.StudentMapper;
import com.gjc.test_demo.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2021-02-11 15:29:05
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

    @Resource
    private StudentMapper studentMapper;


    @Override
    public Student getStudentById(Long id) {
        return this.lambdaQuery().eq(Student::getId, id).one();
    }
}
