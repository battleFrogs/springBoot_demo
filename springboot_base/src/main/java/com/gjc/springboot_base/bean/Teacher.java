package com.gjc.springboot_base.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 通过配置进行注入整个实体类
 */
@Component
@Data
@ConfigurationProperties(prefix = "teacher")
public class Teacher {

    private String teach;
    private String school;


}
