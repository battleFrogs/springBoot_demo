package com.gjc.mybatis_demo.vo;

import lombok.Data;

import java.util.List;

@Data
public class StudentResult  {

//    private static final long serialVersionUID = -1;

    private Long stuId;
    private String name;
    private List<ResultInfoVo> resultInfos;


}
