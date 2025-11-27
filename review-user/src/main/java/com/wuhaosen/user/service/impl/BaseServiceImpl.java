package com.wuhaosen.user.service.impl;

import com.wuhaosen.user.domin.dao.mappers.BaseMapper;
import com.wuhaosen.user.service.BaseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.user.service.impl
 * @ClassName:BaseServiceImpl
 * @Description
 * @Date 2025/10/11 11:45
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {


    @Resource
    private BaseMapper<T> mapper;

    @Override
    public List<T> findAll() {
        return mapper.findAll();
    }

    @Override
    public T findById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public int insert(T data) {
        return mapper.insert(data);
    }

    @Override
    public int update(T data) {
        return mapper.update(data);
    }

    @Override
    public int delete(Long id) {
        return mapper.delete(id);
    }
}
