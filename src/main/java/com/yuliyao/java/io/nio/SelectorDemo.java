package com.yuliyao.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * @author yuliyao
 * @date 2020/7/10
 * 使用 selector 实现多路复用
 */
public class SelectorDemo {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        System.out.println("初始化ssChannel:"+ssChannel);
        ssChannel.configureBlocking(false);
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        ServerSocket serverSocket = ssChannel.socket();
        serverSocket.bind(new InetSocketAddress(6666));
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    System.out.println("接收的ssChannel:" + ssChannel);
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);


                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    StringBuilder sb = new StringBuilder();
                    while (socketChannel.read(byteBuffer) != -1) {
                        byteBuffer.flip();
                        int limit = byteBuffer.limit();
                        byte[] bytes = new byte[limit];
                        for (int i = 0; i < limit; i++) {
                            byte b = byteBuffer.get(i);
                            bytes[i] = b;
                        }
                        sb.append(new String(bytes, StandardCharsets.UTF_8));
                        byteBuffer.clear();
                    }
                    System.out.println(sb.toString());
                    //一定要关闭，否则select()会一直有值
                    socketChannel.close();
                }
                iterator.remove();

            }

        }


    }

}
