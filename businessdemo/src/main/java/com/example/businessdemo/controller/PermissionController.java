package com.example.businessdemo.controller;

import com.example.businessdemo.data.ActInfVo;
import com.example.businessdemo.data.dto.permissionDto;
import com.example.businessdemo.response.ResponseVO;
import com.example.businessdemo.response.Result;
import com.example.businessdemo.response.ResultBuilder;
import com.example.businessdemo.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Value("${jiankang.pingan.damu}")
    private String damuDirector;

    @Resource
    private PermissionService permissionService;

    @PostMapping(value = "/actInf")
    public Result getActInf(@RequestBody permissionDto permissionDto){
        logger.info("damuDirector的值"+damuDirector);
        ArrayList<ActInfVo> actInfVoArryList = permissionService.getActInf();
        return ResultBuilder.success(permissionService.getActInf());
    }

    @PostMapping(value="/mySchool")
    public String getMySchool(@RequestBody permissionDto permissionDto){
        String id = permissionDto.getUserId();
        String name = permissionService.getMyschool(id);
        return name;
    }

    @PostMapping(value = "/permission")
    public ResponseVO getPermissionByUserId(@RequestBody permissionDto permissionDto){
        ResponseVO responseVO = new ResponseVO();
        List<Object> lists = permissionService.getPermissionBy(permissionDto.getUserId());
        responseVO.setData(permissionService.getPermissionBy(permissionDto.getUserId()));
        responseVO.setCode("200");
        return responseVO;
    }
}
