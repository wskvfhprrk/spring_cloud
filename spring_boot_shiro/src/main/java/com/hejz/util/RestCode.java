package com.hejz.util;

import lombok.Data;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 16:03
 */
@Data
public class RestCode {
    private int code;
    private String msg;
    private Object object;

    public RestCode(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public static RestCode ok(){
        return new RestCode(200,"success",null);
    }

    public static RestCode ok(Object object){
        return new RestCode(200, "success", object);
    }

    public static RestCode error(Object object){
        return new RestCode(500,"error",object);
    }
}
