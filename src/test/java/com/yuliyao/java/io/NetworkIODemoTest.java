package com.yuliyao.java.io;

import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/8
 */
public class NetworkIODemoTest {

    NetworkIODemo networkIODemo = new NetworkIODemo();

    @Test
    public void testInetAddress() throws UnknownHostException {
        networkIODemo.testInetAddress();
    }

    @Test
    public void testUrl() throws IOException {
        networkIODemo.testUrl("http://www.baidu.com","F:\\test\\download.html");
    }
}