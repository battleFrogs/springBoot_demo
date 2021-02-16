package com.gjc.mybatis_demo.mapper;

import com.github.pagehelper.Page;
import com.gjc.mybatis_demo.model.Student;
import com.gjc.mybatis_demo.vo.StudentResult;
import org.apache.ibatis.annotations.*;

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


    @Insert(" INSERT INTO `student` " +
            " ( `name`, `created` ) " +
            " VALUES ( #{name} ,#{created} )")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
        // 使用返回主键Id
    boolean saveStudent(Student student);

    /**
     * 保存用户信息
     *
     * @param student 学生信息
     * @return 成功 1 失败 0
     */
    int insert(Student student);


    /**
     * 获取分页结果
     *
     * @return page
     */
    Page<Student> query();

    /**
     * 获取集合结果
     *
     * @return List结果集
     */
    List<Student> queryList();

    StudentResult getResultList();

}
