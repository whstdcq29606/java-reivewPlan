package com.wuhaosen.user.domin;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.user.domin
 * @ClassName:VipUser
 * @Description
 * @Date 2025/9/23 15:31
 */
@Data
public class VipUser extends User{
    private Timestamp topUpTime;
    private Timestamp expiredTime;
}
