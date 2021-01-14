package com.fh.shop.entity.vo;

import java.util.List;

public class ResponseData<T> {

    private Integer code;

    private String message;

    private Object data;

    private ResponseData(){

    }

    public static ResponseData success(Object data){
        ResponseData rs=new ResponseData();
        rs.setCode(200);
        rs.setMessage("处理数据成功");
        rs.setData(data);
        return rs;
    }


    public static ResponseData error(Integer code,String message){
        ResponseData rs=new ResponseData();
        rs.setCode(code);
        rs.setMessage(message);
        rs.setData(null);
        return rs;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
