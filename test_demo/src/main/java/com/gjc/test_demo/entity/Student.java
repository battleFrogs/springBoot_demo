package com.gjc.test_demo.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2021-02-11 14:56:51
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -84095048751338488L;
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date created;


}
