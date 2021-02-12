package com.gjc.test_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gjc.test_demo.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-11 15:12:22
 */
@Repository
public interface StudentMapper extends BaseMapper<Student> {


}

