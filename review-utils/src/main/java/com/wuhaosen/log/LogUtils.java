package com.wuhaosen.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.log
 * @ClassName:LogUtils
 * @Description
 * @Date 2025/10/9 23:03
 */
public class LogUtils {
    // 生成唯一追踪ID
    public static String generateTraceId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // 设置MDC上下文
    public static void setMDCContext() {
        MDC.put("traceId", generateTraceId());
        MDC.put("spanId", generateTraceId().substring(0, 16));
    }

    // 清除MDC上下文
    public static void clearMDCContext() {
        MDC.clear();
    }

    // 获取logger并自动设置上下文
    public static Logger getLogger(Class<?> clazz) {
        setMDCContext();
        return LoggerFactory.getLogger(clazz);
    }

    public static void main(String[] args) {
        System.out.println(generateTraceId());
        System.out.println(generateTraceId().length());
        int a = 3;
        while (a-- > 0) System.out.println(a);

        System.out.println(a);

    }
}
