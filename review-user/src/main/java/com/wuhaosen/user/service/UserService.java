package com.wuhaosen.user.service;

import com.wuhaosen.user.domin.User;
import com.wuhaosen.user.domin.dao.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.user.service
 * @ClassName:UserService
 * @Description
 * @Date 2025/9/23 15:35
 */
public interface UserService extends BaseService<User>{



//    登录处理
    boolean userLogin(User user);


}
