package com.wuhaosen.nio.buffer;

import java.nio.IntBuffer;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.nio.buffer
 * @ClassName:BasicBuffer
 * @Description
 * @Date 2025/9/27 15:52
 */
public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer allocate = IntBuffer.allocate(5);
        for (int i = 0; i < allocate.capacity(); i++) {
            allocate.put(i * 2);
        }

        allocate.flip();
        while (allocate.hasRemaining()) {
            System.out.println(allocate.get());
        }
    }
}
