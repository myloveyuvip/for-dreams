package com.yuliyao.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author YuLiyao
 * @date 2020/7/9
 */
public class SocketDemo {

    public void socketServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket client = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

        }
    }
}
