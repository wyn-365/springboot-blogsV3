package com.wang.springboot.dao;

import com.wang.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //查询用户名和密码
    User findByUsernameAndPassword(String username, String password);
}
