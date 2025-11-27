package com.wuhaosen.user.domin.dao.mappers;

import com.wuhaosen.user.domin.User;

import java.util.List;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.user.domin.dao
 * @ClassName:BaseMapper
 * @Description
 * @Date 2025/9/23 15:36
 */
public interface BaseMapper<T> {
    List<T> findAll();
    T findById(Long id);
    int insert(T data);
    int update(T data);
    int delete(Long id);
}
