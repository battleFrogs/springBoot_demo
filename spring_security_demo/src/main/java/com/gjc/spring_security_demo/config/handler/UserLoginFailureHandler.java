package com.gjc.spring_security_demo.config.handler;

import com.gjc.spring_security_demo.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {


    private final static Logger log = LoggerFactory.getLogger(UserLoginFailureHandler.class);


    /**
     * 登录失败返回结果
     *
     * @Author Sans
     * @CreateTime 2019/10/3 9:12
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        // 这些对于操作的处理类可以根据不同异常进行不同处理
        if (exception instanceof UsernameNotFoundException) {
            log.info("【登录失败】" + exception.getMessage());
            ResultUtils.responseJson(response, ResultUtils.resultCode(500, "用户名不存在"));
        }
        if (exception instanceof LockedException) {
            log.info("【登录失败】" + exception.getMessage());
            ResultUtils.responseJson(response, ResultUtils.resultCode(500, "用户被冻结"));
        }
        if (exception instanceof BadCredentialsException) {
            log.info("【登录失败】" + exception.getMessage());
            ResultUtils.responseJson(response, ResultUtils.resultCode(500, "用户名密码不正确"));
        }
        ResultUtils.responseJson(response, ResultUtils.resultCode(500, "登录失败"));
    }
}
