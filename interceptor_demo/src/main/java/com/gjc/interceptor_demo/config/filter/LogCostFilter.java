package com.gjc.interceptor_demo.config.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 */
// 第二种配置 各自配置
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)  @Order(1)//控制过滤器的级别
//@WebFilter(urlPatterns = "*.json", filterName = "reqResFilter") // 设置过滤器规则
public class LogCostFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException{

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Execute cost=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {

    }


}

