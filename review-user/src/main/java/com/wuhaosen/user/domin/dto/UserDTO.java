package com.wuhaosen.user.domin.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.user.domin.dto
 * @ClassName:UserDTO
 * @Description
 * @Date 2025/10/14 11:14
 */
@Data
public class UserDTO extends BaseDTO{
    private String username;
    private String password;
    private String email;
    private String phone;
    private BigDecimal amount;
    private Integer isVip; // 1 是vip 0非vip
}
