package com.wuhaosen.user.domin;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.user.domin
 * @ClassName:User
 * @Description
 * @Date 2025/9/23 15:28
 */
@Data
public class User extends Base{
    private String username;
    private String password;
    private String email;
    private String phone;
    private BigDecimal amount;
    private Integer isVip; // 1 是vip 0非vip
    private LocalDateTime lastLoginTime;
}
