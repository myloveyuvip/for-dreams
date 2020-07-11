package com.yuliyao.java.io.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author YuLiyao
 * @date 2020/7/11
 */
public class SelectorDemoTest {


    @Test
    public void seletorClient() throws IOException {
        Socket socket = new Socket("localhost", 6666);
        Scanner scanner = new Scanner(System.in);
        System.out.println("client:");
        String line = scanner.nextLine();
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.write(line);
        printWriter.close();
    }

}