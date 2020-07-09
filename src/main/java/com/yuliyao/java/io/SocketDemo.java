package com.yuliyao.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        boolean isRun = true;
        while (isRun) {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端连接！");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String line;
            while (!"bye".equals(line = bufferedReader.readLine())) {
                System.out.println("client：" + line);
                Scanner scanner = new Scanner(System.in);
                System.out.println("server:");
                String returnMsg = scanner.nextLine();
                bufferedWriter.write(returnMsg + "\r");
                bufferedWriter.flush();
            }
            bufferedWriter.close();
            isRun = false;

        }
        System.out.println("连接结束！");
    }

    public static void main(String[] args) throws IOException {
        SocketDemo socketDemo = new SocketDemo();
        socketDemo.socketServer();
    }
}
