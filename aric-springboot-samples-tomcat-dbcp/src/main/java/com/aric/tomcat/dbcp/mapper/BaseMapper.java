package com.aric.tomcat.dbcp.mapper;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @Time : 2017/12/5 21:59
 * @Author : TOM.LEE
 * @File : BaseMapper.java
 */
public interface BaseMapper<T, ID extends Serializable> {

    /**
     * find all
     * @param t
     * @return
     */
    List<T> getAll(@Param("map") T t);

    /**
     * insert for object
     * @param t
     * @return
     */
    int insert(@Param("map") T t);

    /**
     * update for object
     * @param t
     * @return
     */
    int update(@Param("map") T t);

    /**
     * delete by id
     * @param id
     * @return
     */
    int delete(@Param("id") ID id);


}
