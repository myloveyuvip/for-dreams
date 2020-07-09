package com.yuliyao.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @author YuLiyao
 * @date 2020/7/8
 * 网络操作
 */
public class NetworkIODemo {


    public void testInetAddress() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }

    public void testUrl(String stringUrl,String desc) throws IOException {
        URL url = new URL(stringUrl);
        InputStream inputStream = url.openStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(isr);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(desc));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            bufferedWriter.write(line, 0, line.length());
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
