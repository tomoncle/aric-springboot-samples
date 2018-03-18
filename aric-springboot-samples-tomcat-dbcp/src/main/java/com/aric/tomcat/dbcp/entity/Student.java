package com.aric.tomcat.dbcp.entity;

import java.io.Serializable;

/**
 * 学生
 * Created by tom.lee on 2017/12/2.
 */
public class Student implements Serializable {

    private Integer id;
    private Integer studentNo;
    private String name;
    private Major major;
    private Course course;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student(Integer studentNo, String name, Major major, Course course) {
        this.studentNo = studentNo;
        this.name = name;
        this.major = major;
        this.course = course;
    }

    public Student(Integer id, Integer studentNo, String name, Major major, Course course) {
        this.id = id;
        this.studentNo = studentNo;
        this.name = name;
        this.major = major;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
