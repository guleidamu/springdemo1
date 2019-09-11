package com.example.damuMyschool.mapper;

import com.example.damuMyschool.data.dto.TjtbDto;
import com.example.damuMyschool.data.entity.Tjtb;

import java.util.ArrayList;

public interface TjtbMapper {
    int deleteByPrimaryKey(String id);

    int insert(Tjtb record);

    int insertSelective(Tjtb record);

    Tjtb selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Tjtb record);

    int updateByPrimaryKey(Tjtb record);

    ArrayList<Tjtb> getTjtbGp(TjtbDto tjtbDto);
    ArrayList<Tjtb> getTjtbSjByGp(Tjtb tjtb);
}
