package com.yuliyao.java.basis;

import org.junit.Test;

import java.text.MessageFormat;

/**
 * @author YuLiyao
 * @date 2020/8/31
 */
public class RegexTest {

    public static void main(String[] args) {
        String delimeter = "\\|";
        String string = "2020-08-31 03:44:45 INFO sdk iap-queue GPA.3303-0867-0919-62627 103.52.188.132 | - | {\"orderId\":\"9742a66239fb4d8b9d3240713891a7c4\"}";
        String[] split = string.split(delimeter);
        System.out.println(split.length);
        String s = "{\"to\":\"18350027124\",\"message\":\"5601\"}";
    }

    @Test
    public void messageFormat() {
        String str = "This is {0}, Hello {1}";
        System.out.println(MessageFormat.format(str, "neo", "world"));
    }
}
