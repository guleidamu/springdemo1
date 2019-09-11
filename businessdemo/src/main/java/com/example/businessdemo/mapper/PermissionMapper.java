package com.example.businessdemo.mapper;

import com.example.businessdemo.data.ActInfVo;

import java.util.ArrayList;

public interface PermissionMapper {

    ArrayList<ActInfVo> getActInfo();

    ArrayList<Object> getPermissionByUserId(String userId);
}
