package com.aric.tomcat.dbcp.service;

import java.io.Serializable;
import java.util.List;

/**
 * @Time : 2017/12/5 22:17
 * @Author : TOM.LEE
 * @File : BaseService.java
 */
public interface BaseService<T, ID extends Serializable> {
    /**
     * find all
     *
     * @param t
     * @return
     */
    List<T> getAll(T t);

    /**
     * insert for object
     *
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * update for object
     *
     * @param t
     * @return
     */
    int update(T t);

    /**
     * delete by id
     *
     * @param id
     * @return
     */
    int delete(ID id);
}
