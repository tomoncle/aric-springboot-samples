package com.aric.tomcat.rest.entity;

/**
 *
 * Created by liyuanjun on 17-12-13.
 */
public class User {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                '}';
    }
}
