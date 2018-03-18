package com.aric.tomcat.service.impl;

import com.aric.tomcat.entity.User;
import com.aric.tomcat.mapper.UserMapper;
import com.aric.tomcat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tom.lee on 2017/12/2.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> users(String username) {
        return userMapper.users(username);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
