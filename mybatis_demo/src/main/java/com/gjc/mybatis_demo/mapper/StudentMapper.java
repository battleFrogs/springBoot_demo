package com.gjc.mybatis_demo.mapper;

import com.gjc.mybatis_demo.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {


    /**
     * 根据用户名查询用户结果集
     *
     * @param name 用户名
     * @return 查询结果
     */
    @Select("SELECT * FROM student WHERE name = #{name}")
    List<Student> findByUsername(@Param("name") String name);


    /**
     * 保存用户信息
     *
     * @param student 学生信息
     * @return 成功 1 失败 0
     */
    int insert(Student student);

}
