package com.gjc.spring_security_demo.config.handler;

import com.gjc.spring_security_demo.config.JWTConfig;
import com.gjc.spring_security_demo.config.entity.SelfUserEntity;
import com.gjc.spring_security_demo.utils.JWTTokenUtil;
import com.gjc.spring_security_demo.utils.ResultUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    /**
     * 登录成功返回结果
     *
     * @Author Sans
     * @CreateTime 2019/10/3 9:27
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // 组装JWT
        SelfUserEntity selfUserEntity = (SelfUserEntity) authentication.getPrincipal();
        String token = JWTTokenUtil.createAccessToken(selfUserEntity);
        token = JWTConfig.tokenPrefix + token;
        // 封装返回参数
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("code", "200");
        resultData.put("msg", "登录成功");
        resultData.put("token", token);
        ResultUtils.responseJson(response, resultData);
    }
}
