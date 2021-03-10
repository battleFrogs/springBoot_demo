package com.gjc.interceptor_demo.config.response;

import com.gjc.interceptor_demo.config.request.CustomRequestAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 对有响应体的response处理
 */
@ControllerAdvice
public class CustomResponseAdvice implements ResponseBodyAdvice {

    private static final Logger logger = LoggerFactory.getLogger(CustomRequestAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // 返回true，表示启动拦截
        return true;
    }

    @Override
    public String beforeBodyWrite(Object o, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {

        logger.info("CustomResponseAdvice beforeBodyWrite");

        // 添加前缀
        String raw = String.valueOf(o);
        return "PREFIX:" + raw;
    }




}
