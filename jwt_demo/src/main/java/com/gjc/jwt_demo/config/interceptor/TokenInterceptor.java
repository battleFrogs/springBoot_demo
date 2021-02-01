package com.gjc.jwt_demo.config.interceptor;

import com.gjc.jwt_demo.config.JwtConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private JwtConfig jwtConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        if (request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("200");
            return true;
        }
        System.out.println(jwtConfig.getTokenHeader());
        String token = request.getHeader(jwtConfig.getTokenHeader());

        if (token != null){
//            boolean result = JwtUtils.verifyToken(token);
//            if(result){
            System.out.println(token);
            System.out.println("通过拦截器");
            return true;
//            }
        }
        System.out.println("认证失败");
        response.getWriter().write("401");

        return false;
    }

}
