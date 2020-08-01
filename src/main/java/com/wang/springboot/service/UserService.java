package com.wang.springboot.service;

import com.wang.springboot.pojo.User;

public interface UserService {

    User checkUser(String username, String password);
}
