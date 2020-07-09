package com.yuliyao.java.io;

import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/9
 */
public class SocketDemoTest {

    @Test
    public void testConnectSocket() throws IOException {
        Socket socket = new Socket("localhost", 6666);

    }

}