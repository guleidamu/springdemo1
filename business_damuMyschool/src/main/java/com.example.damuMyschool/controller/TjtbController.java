package com.example.damuMyschool.controller;

import com.example.damuMyschool.data.dto.TjtbDto;
import com.example.damuMyschool.response.Result;
import com.example.damuMyschool.response.ResultBuilder;
import com.example.damuMyschool.service.TjtbService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/tjtb")
public class TjtbController {

    @Resource
    private TjtbService tjtbService;

    @PostMapping(value = "/fenzu")
    public Result getTjtbGb(@RequestBody TjtbDto tjtbDto){
       Result result = tjtbService.fenZuTongJi(tjtbDto);
       return result;
    }
}
