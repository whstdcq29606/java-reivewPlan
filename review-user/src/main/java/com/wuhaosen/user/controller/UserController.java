package com.wuhaosen.user.controller;

import com.wuhaosen.user.domin.User;
import com.wuhaosen.user.domin.dto.UserDTO;
import com.wuhaosen.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.user.controller
 * @ClassName:RegisterController
 * @Description
 * @Date 2025/9/23 15:34
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController{

    @Resource
    private UserService userService;

    //    注册页面
    @RequestMapping("/register")
    public String register() {
        return "123";
    }

    @PostMapping("/findAll")
    public List<UserDTO> findAll() {
        List<User> userList = userService.findAll();
        List<UserDTO> userDTOList= new ArrayList<>();
        for (User u : userList) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(u,userDTO);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

}
