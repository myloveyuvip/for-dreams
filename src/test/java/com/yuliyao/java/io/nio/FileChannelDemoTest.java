package com.yuliyao.java.io.nio;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author yuliyao
 * @date 2020/7/10
 */
public class FileChannelDemoTest {


    FileChannelDemo channelDemo = new FileChannelDemo();

    @Test
    public void fastCopy() throws IOException {
        channelDemo.fastCopy("/Users/yuliyao/Movies/test.txt","/Users/yuliyao/Movies/test2.txt");


    }

}