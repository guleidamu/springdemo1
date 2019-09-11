package com.example.damuMyschool.response;

import java.io.Serializable;

public class ResultBuilder {
    private ResultBuilder(){}

    public static <T extends Serializable> Result<T> success(T data){
        Result<T> result = new Result<T>();
        result.setData(data);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        return result;
    }

    public static Result error(String code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setSuccess(false);
        result.setDescription(message);
        return result;
    }

    public static Result error(IResultCode code,String message){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code.code());
        result.setDescription(message);
        return result;
    }

    public static Result error(IResultCode code){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code.code());
        result.setDescription(code.description());
        return result;
    }

    public static Result error(Result r){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(r.getCode());
        result.setDescription(r.getDescription());
        return result;
    }

//    public static Result error(BusinessException e){
//
//    }
}
