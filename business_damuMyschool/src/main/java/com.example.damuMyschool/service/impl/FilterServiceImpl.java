package com.example.damuMyschool.service.impl;

import com.example.damuMyschool.data.entity.Filter;
import com.example.damuMyschool.mapper.FilterMapper;
import org.springframework.stereotype.Service;
import com.example.damuMyschool.service.FilterService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    @Resource
    private FilterMapper filterMapper;

    public List<Filter> getFilterByNo(Integer no) {
        return filterMapper.getFilterByNo(no);
    }
}
