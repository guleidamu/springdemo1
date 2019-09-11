package com.example.damuMyschool.service.impl;

import com.example.damuMyschool.data.entity.Student;
import com.example.damuMyschool.mapper.StudentMapper;
import com.example.damuMyschool.service.studentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class studentServiceImpl implements studentService {

    @Resource
    private StudentMapper studentMapper;

    public Student selectStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
