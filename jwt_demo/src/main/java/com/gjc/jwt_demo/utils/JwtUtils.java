package com.gjc.jwt_demo.utils;

import cn.hutool.core.date.DateUtil;
import com.gjc.common.constant.ResultData;
import com.gjc.jwt_demo.config.JwtConfig;
import com.gjc.jwt_demo.entity.SelfUserEntity;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class JwtUtils {

    @Resource
    private JwtConfig jwtConfig;

    /**
     * 生成Token
     */
    public String createAccessToken(SelfUserEntity selfUserEntity){
        // 登陆成功生成JWT
        String token = Jwts.builder()
                // 放入用户名和用户ID
                .setId(selfUserEntity.getUserId())
                // 主题
                .setSubject("user")
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("gjc")
                // 自定义属性 放入用户拥有权限
//                .claim("authorities", JSON.toJSONString(selfUserEntity.getAuthorities()))
                .claim("role", selfUserEntity.getRoleStatus())
                .claim("openId", selfUserEntity.getOpenId())
//                .claim("avatarUrl", selfUserEntity.getAvatarUrl())
                // 失效时间
                .setExpiration(DateUtil.offsetSecond(new Date(), jwtConfig.getExpiration()))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret())
                .compact();

        return token;
    }


    /**
     * 解析token值
     * @param token token
     * @return resultData
     */
    public ResultData verifyToken(String token) {

        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return new ResultData(ResultData.ResultEnum.ERROR.getCode(), "解析错误");
        }

        SelfUserEntity selfUserEntity = new SelfUserEntity();
        selfUserEntity.setUserId(claims.getId());
        selfUserEntity.setOpenId(claims.get("openId").toString());
        selfUserEntity.setRoleStatus(claims.get("role").toString());

        ResultData resultData = new ResultData();
        resultData.setCode(ResultData.ResultEnum.SUCCESS.getCode());
        resultData.addData("selfUserEntity", selfUserEntity);
        resultData.addData("token", token);

        return resultData;

    }


}
