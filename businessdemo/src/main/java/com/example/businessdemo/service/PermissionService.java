package com.example.businessdemo.service;

import com.example.businessdemo.data.ActInfVo;

import java.util.ArrayList;
import java.util.List;

public interface PermissionService {

    ArrayList<ActInfVo> getActInf();

    List<Object> getPermissionBy(String userId);

    String getMyschool(String id);
}
