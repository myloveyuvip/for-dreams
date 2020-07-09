package com.yuliyao.java.io;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/8
 */
public class ReaderDemoTest {

    private ReaderDemo readerDemo = new ReaderDemo();

    @Test
    public void encode() {

        readerDemo.encode();
    }

    @Test
    public void readAndWrite() throws IOException {
        readerDemo.readAndWrite("F:\\test\\test.txt","F:\\test\\test_copy.txt");

    }
}