package com.gjc.mybatis_demo.mapper;

import com.gjc.mybatis_demo.model.ResultInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResultMapper {


    boolean saveResult(ResultInfo resultInfo);


    boolean deleteResult(List<Long> ids);


    List<ResultInfo> selectResultInfoList(@Param("name") String name);

}
