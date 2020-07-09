package com.yuliyao.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author YuLiyao
 * @date 2020/7/9
 */
public class SocketDemo {

    public void socketServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            Socket client = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != "bye") {
                System.out.println("client：" + line);
                Scanner scanner = new Scanner(System.in);
                System.out.println("server：");
                String returnMsg = scanner.nextLine();
                client.getOutputStream().write(returnMsg.getBytes(StandardCharsets.UTF_8));
            }

        }
    }

    public static void main(String[] args) throws IOException {
        SocketDemo socketDemo = new SocketDemo();
        socketDemo.socketServer();
    }
}
