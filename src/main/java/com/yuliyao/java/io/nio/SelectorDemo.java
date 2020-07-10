package com.yuliyao.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author yuliyao
 * @date 2020/7/10
 * 使用 selector 实现多路复用
 */
public class SelectorDemo {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        ServerSocket serverSocket = ssChannel.socket();
        serverSocket.bind(new InetSocketAddress(6666));
        while (true) {
            SocketChannel accept = ssChannel.accept();

        }


    }

}
