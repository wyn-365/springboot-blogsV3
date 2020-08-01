package com.wang.springboot.service;

import com.wang.springboot.dao.UserRepository;
import com.wang.springboot.pojo.User;
import com.wang.springboot.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override//MD5加密密码
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
