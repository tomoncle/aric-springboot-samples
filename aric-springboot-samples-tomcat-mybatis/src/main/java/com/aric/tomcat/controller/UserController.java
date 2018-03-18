package com.aric.tomcat.controller;

import com.aric.tomcat.entity.User;
import com.aric.tomcat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * user controller
 * Created by tom.lee on 2017/12/2.
 */
@RestController
@RequestMapping("/rest/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public List<User> userList(@RequestParam(required = false) String username){
        return userService.users(username);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User user(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }
}
