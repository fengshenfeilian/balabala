package com.managementSystem.pojo;

import java.util.HashMap;
import java.util.Map;

/*
 *通用json返回类
 */
public class Msg {
    //状态码 100成功 200失败
    private int code;
    //提示信息
    private String message;
    //携带数据
    private Map<String,Object> extend = new HashMap<String,Object>();

    public static Msg success(String message){
        Msg result = new Msg();
        result.setCode(100);
        result.setMessage(message);
        return result;
    }

    public static Msg fail(String message){
        Msg result = new Msg();
        result.setCode(200);
        result.setMessage(message);
        return result;
    }

    //链式操作方法
    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
