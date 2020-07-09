package com.yuliyao.java.io;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author YuLiyao
 * @date 2020/7/8
 * 字符操作
 */
public class ReaderDemo {

    /**
     * 编码就是把字符转换为字节，而解码是把字节重新组合成字符
     */
    public void encode() {
        String str = "中文a";
        System.out.println(JSON.toJSONString(str.getBytes()));
        byte[] b= str.getBytes(StandardCharsets.UTF_8);
        String s = new String(b);
        System.out.println(s);
    }

    public void readAndWrite(String src, String desc) throws IOException {
        FileReader fileReader = new FileReader(src);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(desc));
        while ((line = bufferedReader.readLine())!=null) {
            System.out.println(line);
            bufferedWriter.write(line,0,line.length());
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }


}
