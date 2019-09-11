package com.example.damuMyschool.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

//@Data
public class Result<T extends Serializable> implements Serializable  {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "响应结果代码", required= true)
    private  String code;

    @ApiModelProperty(value = "响应结果描述", required= true)
    private  String description;

    @ApiModelProperty(value = "成功标志", required= true)
    private  boolean success;

    @ApiModelProperty(value = "响应结果数据", required= true)
    private  T data;

    public Result(){
        this.code = ResultCode.SUCCESS.code();
        this.description = ResultCode.SUCCESS.description();
        this.success = true;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
