package com.aric.tomcat.dbcp.mapper;


import com.aric.tomcat.dbcp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserDao
 * Created by tom.lee on 2017/12/2.
 */
@Mapper
public interface UserMapper {

    List<User> users(@Param("username") String username);

    User getUserById(@Param("userId") int id);

    int insertUser(@Param("user") User user);

    int updateUser(@Param("user") User user);

    int deleteUser(@Param("userId") int userId);

}
