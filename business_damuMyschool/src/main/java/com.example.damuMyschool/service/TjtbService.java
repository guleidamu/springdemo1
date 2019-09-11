package com.example.damuMyschool.service;

import com.example.damuMyschool.data.dto.TjtbDto;
import com.example.damuMyschool.data.entity.Tjtb;
import com.example.damuMyschool.data.vo.TjtbVo;
import com.example.damuMyschool.response.Result;

import java.util.ArrayList;

public interface TjtbService {

    Result fenZuTongJi(TjtbDto tjtbDto);

    ArrayList<Tjtb> getTjtbGp(TjtbDto tjtbDto);

    ArrayList<Tjtb> getTjtbSjByGp(TjtbDto tjtbDto);
}
