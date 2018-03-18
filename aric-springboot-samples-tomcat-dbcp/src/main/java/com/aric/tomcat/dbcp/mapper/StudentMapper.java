package com.aric.tomcat.dbcp.mapper;

import com.aric.tomcat.dbcp.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Time : 2017/12/5 22:29
 * @Author : TOM.LEE
 * @File : StudentMapper.java
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student,Integer> {

}
