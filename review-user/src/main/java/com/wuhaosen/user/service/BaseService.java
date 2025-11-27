package com.wuhaosen.user.service;

import com.wuhaosen.user.domin.User;
import com.wuhaosen.user.domin.dao.mappers.UserMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.user.service
 * @ClassName:BaseService
 * @Description
 * @Date 2025/10/11 11:40
 */
public interface BaseService<T>{

    public List<T> findAll();


    public T findById(Long id);

    public int insert(T data);

    public int update(T data);

    public int delete(Long id);
}
