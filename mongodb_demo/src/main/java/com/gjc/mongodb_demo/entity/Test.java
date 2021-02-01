package com.gjc.mongodb_demo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "test")
public class Test {

    private Integer id;
    private String name;
    private Date created;



}
