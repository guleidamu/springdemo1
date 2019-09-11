package com.example.businessdemo.service.impl;

import com.example.businessdemo.entity.User;
import com.example.businessdemo.mapper.UserMapper;
import com.example.businessdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    public int delete(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
