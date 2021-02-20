package com.gjc.common.utils;

import com.alibaba.fastjson.JSON;
import com.gjc.common.constant.ResultData;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseWriterUtils {

    public static void write(ResultData resultData, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSON.toJSONString(resultData));

    }

}
