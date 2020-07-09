package com.yuliyao.java.io;

import org.junit.Test;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author YuLiyao
 * @date 2020/7/9
 */
public class SocketDemoTest {

    SocketDemo socketDemo = new SocketDemo();


    @Test
    public void testConnectSocket() throws IOException {
        Socket socket = new Socket("localhost", 6666);
        while (true) {

            System.out.println("client:");
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine();

            socket.getOutputStream().write(msg.getBytes());
            socket.getOutputStream().flush();
        }

       /* while ((line = reader.readLine()) != "bye") {
            System.out.println("server:" + line);
            Scanner scanner1= new Scanner(System.in);
            String msg1 = scanner1.nextLine();

            socket.getOutputStream().write(msg1.getBytes());
        }*/

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