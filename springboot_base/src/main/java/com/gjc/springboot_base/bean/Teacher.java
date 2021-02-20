package com.gjc.springboot_base.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "teacher")
public class Teacher {

    private String teach;
    private String school;


}
