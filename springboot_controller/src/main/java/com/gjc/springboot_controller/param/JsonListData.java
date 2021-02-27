package com.gjc.springboot_controller.param;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class JsonListData {

    private List<JsonListDataBean> list;

    @Data
    public static class JsonListDataBean {

        private String name;
        private Integer age;
        private Double price;
        private BigDecimal total;
        private Date date;


    }


}
