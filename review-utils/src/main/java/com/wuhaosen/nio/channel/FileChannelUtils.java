package com.wuhaosen.nio.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.nio.channel
 * @ClassName:FileChannel
 * @Description
 * @Date 2025/9/27 17:20
 */
public class FileChannelUtils {

    public static void main(String[] args) throws IOException {
        writeFile( readFile("text01.txt"), "text02.txt");
        FileChannel open = FileChannel.open(Paths.get("text01.txt"), StandardOpenOption.READ);
        open.map(FileChannel.MapMode.READ_WRITE, 0, open.size());

    }

    private static void writeFile(String outputData, String fileName) throws IOException {
//        获取FileOutPutStream
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
//        获取stream对应的channel
        FileChannel channel = fileOutputStream.getChannel();
//        获取Bytebuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        put数据到buffer
        byteBuffer.put(outputData.getBytes());
//        buffer指针翻转
        byteBuffer.flip();
//        写输入到channel
        channel.write(byteBuffer);
//        关闭stream
        fileOutputStream.close();
    }


    private static String readFile(String fileName) throws IOException {
//        buffer能打开文件吗？似乎不能。看来只能用IO里的对象了。
        File file = new File(fileName);
//        实际上并没有读文件中的数据。
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();

//        获取文件数据
        //        获取buff
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
//        读到buffer
        channel.read(byteBuffer);
        byteBuffer.flip();
        fileInputStream.close();
        return new String(byteBuffer.array());

    }
}
