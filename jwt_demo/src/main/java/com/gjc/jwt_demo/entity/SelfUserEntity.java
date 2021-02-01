package com.gjc.jwt_demo.entity;

import lombok.Data;

@Data
public class SelfUserEntity {

    private String userId;
    private String openId;
    private String roleStatus;

}
