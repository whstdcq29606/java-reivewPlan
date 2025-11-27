package com.wuhaosen.user.domin;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.user.domin.dao
 * @ClassName:Base
 * @Description
 * @Date 2025/10/13 11:37
 */
@Data
public class Base {
    Long id;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
