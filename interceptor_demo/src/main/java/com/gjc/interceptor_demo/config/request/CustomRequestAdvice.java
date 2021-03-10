package com.gjc.interceptor_demo.config.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 对有请求体内容request的拦截处理
 */
@ControllerAdvice
public class CustomRequestAdvice extends RequestBodyAdviceAdapter {


    private static final Logger logger = LoggerFactory.getLogger(CustomRequestAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType,
                            Class converterType) {
        // 返回true，表示启动拦截
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
                                  Type targetType, Class converterType) {
        logger.info("CustomRequestAdvice handleEmptyBody");

        // 对于空请求体，返回对象
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
                                           Class converterType) throws IOException {
        logger.info("CustomRequestAdvice beforeBodyRead");

        // 可定制消息序列化
//        return new BodyInputMessage(inputMessage);
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
                                Class converterType) {
        logger.info("CustomRequestAdvice afterBodyRead");

        // 可针对读取后的对象做转换，此处不做处理
        return body;
    }

}
