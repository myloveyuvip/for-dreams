package com.yuliyao.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author YuLiyao
 * @date 2020/7/8
 */
public class FileDemo {

    /**
     * 遍历文件夹下所有的文件
     * @param path
     */
    public void listAllFile(String path) {
        File file = new File(path);
        if (file.isFile()) {
            System.out.println(file.getName());
            return;
        }
        for (File file1 : file.listFiles()) {
            listAllFile(file1.getPath());
        }
    }

    /**
     * 不使用递归遍历所有文件
     *
     * @param path
     */
    public void listFilesWithoutRecursive(String path) {
        // FIXME: 2020/7/9 不会写
        File file = new File(path);
        if (file.isFile()) {
            System.out.println(file.getPath());
            return;
        }
        while (!file.isFile()) {
            for (File listFile : file.listFiles()) {
                
            }
        }
    }




    public void nameAndPath(String path) {
        File file = new File(path);
        System.out.println(file.exists());
        System.out.println("name:" + file.getName());
        System.out.println("path:" + file.getPath());
    }

    /**
     * 字节流拷贝文件
     *
     * @param src
     * @param dest
     */
    public void copyFile(String src, String dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        byte[] b = new byte[3];
        int cnt;
        while ((cnt = fis.read(b)) != -1) {
            fos.write(b, 0, cnt);
        }
        fis.close();
        fos.close();
    }

    /**
     * 缓存字节流拷贝文件
     *
     * @param src
     * @param dest
     */
    public void copyFileWithBuffer(String src, String dest) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        byte[] b = new byte[3];
        int cnt;
        while ((cnt = bis.read(b)) != -1) {
            bos.write(b, 0, cnt);
        }
        bis.close();
        //FilterOutputStream#close会flushBuffer
        bos.close();
    }

    /**
     * 验证new FileInputStream时是否已经将整个文件载入内存中
     */
    public void testInputStream() throws FileNotFoundException {
        long l1 = System.nanoTime();
        FileInputStream fileInputStream = new FileInputStream("F:\\test\\test.txt");
        long l2 = System.nanoTime();

        System.out.println("读小文件耗时：" + (l2 - l1));
        new FileInputStream("F:\\BaiduNetdiskDownload\\MATLAB-R2017a\\R2017a_win64_dvd1.iso");

        System.out.println("读大文件耗时：" + (System.nanoTime() - l2));



    }

}
