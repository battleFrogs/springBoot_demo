package com.gjc.common.constant;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultData implements java.io.Serializable {


    @Getter
    public static enum ResultEnum {
        ERROR(500, "服务器错误"),
        SUCCESS(200, "成功"),

        ;


        ResultEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        private Integer code;
        private String msg;

    }


    /**
     * 默认生成的序列号
     */
    private static final long serialVersionUID = 1L;


    private Integer code = 200;//默认成功

    private String msg = "";


    private Map<String, Object> data = new HashMap<>(32);

    public ResultData() {
    }

    public ResultData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(Integer code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

}
