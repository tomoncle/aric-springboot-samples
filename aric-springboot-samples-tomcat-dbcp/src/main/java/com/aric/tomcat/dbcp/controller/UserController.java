package com.aric.tomcat.dbcp.controller;


import com.aric.tomcat.dbcp.entity.User;
import com.aric.tomcat.dbcp.service.UserService;
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
    public List<User> list(@RequestParam(required = false) String username){
        return userService.users(username);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestParam("username") String username,
                     @RequestParam("password") String password) {
        User user=new User(username,password);
        int i = userService.insertUser(user);
        if(i>0){
            return user;
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestParam("userId") int userId,
                       @RequestParam("username") String username,
                       @RequestParam("password") String password) {
        User user=new User(userId,username,password);
        int i = userService.updateUser(user);
        if(i>0){
            return user;
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }


}
