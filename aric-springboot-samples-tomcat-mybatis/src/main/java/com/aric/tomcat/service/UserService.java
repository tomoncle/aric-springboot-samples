package com.aric.tomcat.service;

import com.aric.tomcat.entity.User;

import java.util.List;

/**
 *
 * Created by tom.lee on 2017/12/2.
 */
public interface UserService {
    List<User> users(String username);

    User getUserById(int id);
}
