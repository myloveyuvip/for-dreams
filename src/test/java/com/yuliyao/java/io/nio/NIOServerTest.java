package com.yuliyao.java.io.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/11
 */
public class NIOServerTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }

}