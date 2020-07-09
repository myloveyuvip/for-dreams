package com.yuliyao.java.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/8
 */
public class FileDemoTest {

    private FileDemo fileDemo = new FileDemo();

    @Test
    public void listAllFile() {
        fileDemo.listAllFile("F:\\test");
    }

    @Test
    public void nameAndPath() {
        fileDemo.nameAndPath("F:\\test\\test.txt11");
    }

    @Test
    public void copyFile() throws IOException {
        fileDemo.copyFile("F:\\test\\test.txt","F:\\test\\test_copy.txt");
    }

    @Test
    public void copyFileWithBuffer() throws IOException {
        fileDemo.copyFileWithBuffer("F:\\test\\test.txt","F:\\test\\test_copy.txt");
    }

    @Test
    public void listFilesWithoutRecursive() {
    }

    @Test
    public void testInputStream() throws FileNotFoundException {
        fileDemo.testInputStream();
    }
}