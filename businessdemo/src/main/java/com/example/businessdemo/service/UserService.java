package com.example.businessdemo.service;

import com.example.businessdemo.entity.User;

public interface UserService {

    int addUser(User user);

    int delete(Integer id);

    int updateUser(User user);

    User getUserById(Integer id);
}
