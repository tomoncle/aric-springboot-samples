package com.aric.tomcat.mapper;

import com.aric.tomcat.entity.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * UserDao
 * Created by tom.lee on 2017/12/2.
 */

public interface UserMapper {

//    @Select("select * from t_user")
    List<User> users(@Param("username") String username);

    User getUserById(@Param("userId") int id);
}
