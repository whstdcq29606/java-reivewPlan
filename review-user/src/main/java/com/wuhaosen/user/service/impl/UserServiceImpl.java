package com.wuhaosen.user.service.impl;

import com.wuhaosen.user.domin.User;
import com.wuhaosen.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.user.service.impl
 * @ClassName:UserServiceImpl
 * @Description
 * @Date 2025/9/23 15:37
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


    @Override
    public boolean userLogin(User user) {
        return false;
    }

}
