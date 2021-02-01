package com.gjc.jwt_demo.web;

import com.gjc.common.constant.ResultData;
import com.gjc.common.utils.HttpUtils;
import com.gjc.jwt_demo.config.JwtConfig;
import com.gjc.jwt_demo.entity.SelfUserEntity;
import com.gjc.jwt_demo.utils.JwtUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private JwtConfig jwtConfig;

    @RequestMapping("/createJWt")
    public ResultData createJWt() {

        ResultData resultData = new ResultData(ResultData.ResultEnum.SUCCESS.getCode(), "成功");
        SelfUserEntity entity = new SelfUserEntity();
        entity.setUserId("1234");
        entity.setOpenId("1222222");
        entity.setRoleStatus("ADMIN");

        String accessToken = jwtUtils.createAccessToken(entity);
        resultData.addData("result", accessToken);
        return resultData;
    }

    @RequestMapping("/getJWt")
    public ResultData getJWt() {

        String header = HttpUtils.getRequest().getHeader(jwtConfig.getTokenHeader());
        return jwtUtils.verifyToken(header);


    }




}
