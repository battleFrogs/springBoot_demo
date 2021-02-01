package com.gjc.spring_security_demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTConfig {
    /**
     * 密钥KEY
     */
    public static String secret;
    /**
     * TokenKey
     */
    public static String tokenHeader;
    /**
     * Token前缀字符
     */
    public static String tokenPrefix;
    /**
     * 过期时间
     */
    public static Integer expiration;
    /**
     * 不需要认证的接口
     */
    public static String antMatchers;


    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public void setExpiration(Integer expiration) {
        this.expiration = expiration * 1000;
    }

    public void setAntMatchers(String antMatchers) {
        this.antMatchers = antMatchers;
    }

    public static String getSecret() {
        return secret;
    }

    public static String getTokenHeader() {
        return tokenHeader;
    }

    public static String getTokenPrefix() {
        return tokenPrefix;
    }

    public static Integer getExpiration() {
        return expiration;
    }

    public static String getAntMatchers() {
        return antMatchers;
    }
}
