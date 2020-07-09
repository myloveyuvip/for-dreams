package com.yuliyao.java.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author YuLiyao
 * @date 2020/7/9
 */
public class SocketDemoTest {

    private SocketDemo socketDemo = new SocketDemo();


    @Test
    public void testConnectSocket() throws IOException {
        Socket socket = new Socket("localhost", 6666);
        boolean isRun = true;
        while (isRun) {

            System.out.println("client:");
            Scanner scanner = new Scanner(System.in);
            String clinetMsg = scanner.nextLine();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(clinetMsg + "\r");
            bufferedWriter.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while (!(line = reader.readLine()).equals("bye")) {

                System.out.println("server:" + line);
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("client:");
                String msg1 = scanner1.nextLine();
                bufferedWriter.write(msg1 + "\r");
                bufferedWriter.flush();
            }
            bufferedWriter.close();
            scanner.close();
            isRun = false;
        }



    }

    @Test
    public void socketServer() throws IOException {
        socketDemo.socketServer();

    }

    @Test
    public void testSystemIn() {
       Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String s = scanner.nextLine();
        System.out.println("您输入了：" + s);

    }

    @Test
    public void testString() {
        String str = "test";
        String st1 = "test";
        System.out.println(str == st1);
        System.out.println(str == "test");
    }



}