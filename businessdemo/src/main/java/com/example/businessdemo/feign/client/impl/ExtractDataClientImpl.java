package com.example.businessdemo.feign.client.impl;

import com.example.businessdemo.data.vo.Qid;
import com.example.businessdemo.feign.client.ExtractData;
import com.example.businessdemo.response.ResponseVO;

public class ExtractDataClientImpl implements ExtractData {
    public String getMyschool(Qid qid) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode("500");
        responseVO.setDescription("网络通信失败");
        return responseVO.toString();
    }
}
