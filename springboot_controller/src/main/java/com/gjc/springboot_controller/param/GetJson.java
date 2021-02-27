package com.gjc.springboot_controller.param;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GetJson {

    private String name;
    private Integer age;
    private Double price;
    private BigDecimal total;
    private Date date;



}
