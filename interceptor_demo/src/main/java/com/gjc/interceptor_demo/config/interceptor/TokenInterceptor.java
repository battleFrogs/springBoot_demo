package com.gjc.interceptor_demo.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器实现
 */
@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {


    /*
     * Controller方法调用前，返回true表示继续处理
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        if (request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("200");
            return true;
        }
        String token = request.getHeader("token");
        if (token != null){
//            boolean result = JwtUtils.verifyToken(token);
//            if(result){
            System.out.println("通过拦截器");
            return true;
//            }
        }
        System.out.println("认证失败");
        response.getWriter().write("401");

        return false;
    }

    /*
     * Controller方法调用后，视图渲染前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        HandlerMethod method = (HandlerMethod) handler;
        log.info("CustomerHandlerInterceptor postHandle, {}", method.getMethod().getName());

        response.getOutputStream().write("append content".getBytes());
    }

    /*
     * 整个请求处理完，视图已渲染。如果存在异常则Exception不为空
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        HandlerMethod method = (HandlerMethod) handler;
        log.info("CustomerHandlerInterceptor afterCompletion, {}", method.getMethod().getName());
    }

}
