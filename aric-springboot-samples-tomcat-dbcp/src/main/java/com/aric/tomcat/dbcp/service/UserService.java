package com.aric.tomcat.dbcp.service;

import com.aric.tomcat.dbcp.entity.User;

import java.util.List;

/**
 *
 * Created by tom.lee on 2017/12/2.
 */
public interface UserService {
    List<User> users(String username);

    User getUserById(int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int userId);
}
