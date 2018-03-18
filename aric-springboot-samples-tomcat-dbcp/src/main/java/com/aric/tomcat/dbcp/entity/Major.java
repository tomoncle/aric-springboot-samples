package com.aric.tomcat.dbcp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 专业
 *
 * Major:Student== 1:n
 * Created by tom.lee on 2017/12/2.
 */
public class Major implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private List<Student> studentList; //一个专业的学生列表
    private List<Course> courseList; // 一个专业的课程列表

    public Major(Integer id) {
        this.id = id;
    }

    public Major(String name, String description, List<Student> studentList, List<Course> courseList) {
        this.name = name;
        this.description = description;
        this.studentList = studentList;
        this.courseList = courseList;
    }

    public Major(Integer id, String name, String description, List<Student> studentList, List<Course> courseList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.studentList = studentList;
        this.courseList = courseList;
    }

    public Major() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
