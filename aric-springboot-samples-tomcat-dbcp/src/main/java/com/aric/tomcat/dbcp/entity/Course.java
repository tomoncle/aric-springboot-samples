package com.aric.tomcat.dbcp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 课程：专业=n:n
 * @Time : 2017/12/5 21:57
 * @Author : TOM.LEE
 * @File : Course.java
 */
public class Course implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private List<Student> studentList; //一个课程的学生列表
    private List<Major> majorList; // 一个课程的包含的专业列表

    public Course(Integer id) {
        this.id = id;
    }

    public Course(String name, String description, List<Student> studentList, List<Major> majorList) {
        this.name = name;
        this.description = description;
        this.studentList = studentList;
        this.majorList = majorList;
    }

    public Course(Integer id, String name, String description, List<Student> studentList, List<Major> majorList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.studentList = studentList;
        this.majorList = majorList;
    }

    public Course() {
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

    public List<Major> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<Major> majorList) {
        this.majorList = majorList;
    }
}
