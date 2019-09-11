package com.example.damuMyschool.mapper;

import com.example.damuMyschool.data.entity.Filter;

import java.util.List;

public interface FilterMapper {
    int insert(Filter record);

    int insertSelective(Filter record);

    List<Filter> getFilterByNo(Integer versionNo);
}