package com.aric.tomcat.dbcp.service.impl;

import com.aric.tomcat.dbcp.mapper.BaseMapper;
import com.aric.tomcat.dbcp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Time : 2017/12/5 22:18
 * @Author : TOM.LEE
 * @File : BaseServiceImpl.java
 */
public class BaseServiceImpl<T> implements BaseService<T,Integer> {

    @Autowired
    private BaseMapper<T,Integer> baseMapper;

    @Override
    public List<T> getAll(T t) {
        return baseMapper.getAll(t);
    }

    @Override
    public int insert(T t) {
        return baseMapper.insert(t);
    }

    @Override
    public int update(T t) {
        return baseMapper.update(t);
    }

    @Override
    public int delete(Integer id) {
       return baseMapper.delete(id);
    }
}
