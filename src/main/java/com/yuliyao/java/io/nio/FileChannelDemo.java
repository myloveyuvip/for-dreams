package com.yuliyao.java.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yuliyao
 * @date 2020/7/10
 */
public class FileChannelDemo {

    /**
     * 使用 channel快速复制文件
     *
     * @param src
     * @param dest
     */
    public void fastCopy(String src, String dest) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(src);
        FileChannel fic = fileInputStream.getChannel();

        FileChannel foc = new FileOutputStream(dest).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fic.read(byteBuffer) != -1) {
            byteBuffer.flip();
            foc.write(byteBuffer);
            //切记要clear，否则会一直复制
            byteBuffer.clear();
        }
        fic.close();
        foc.close();

    }
}
