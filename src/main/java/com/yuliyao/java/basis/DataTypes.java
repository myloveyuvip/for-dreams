package com.yuliyao.java.basis;

import java.util.Objects;

/**
 * @author YuLiyao
 * @date 2020/7/4
 */
public class DataTypes {

    public void charType() {
        char c = 'a';
        Character cha = 'a';
        String str = "a";
        Integer i = 97;
        System.out.println("c == cha? "+ (c == cha));
        System.out.println("Objects.equals(c, str)? " + Objects.equals(c, str));
        System.out.println("c == i? " + (c == i));
        System.out.println(cha.charValue());
        System.out.println(cha.toString());
        //打印char对应的int值
        System.out.println((int) c);
        System.out.println((int) cha);
        //中文字符
        char ch = '我';
        System.out.println(ch);
        System.out.println((int)ch);
        char ch2 = (char) 84426;
        System.out.println(ch2);

    }

    public void charMethod(Character c) {
        System.out.println(c + " isLetter? -->" + Character.isLetter(c));
        System.out.println(c + " isDigit? -->" + Character.isDigit(c));
        System.out.println(c + " isWhitespace? -->" + Character.isWhitespace(c));
        System.out.println(c + " isUpperCase? -->" + Character.isUpperCase(c));
        System.out.println(c + " isLowerCase? -->" + Character.isLowerCase(c));
    }

    public boolean isDigital(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public void byteType() {
        byte b = 1;
        byte b2 = '1';
        System.out.println(b);
        System.out.println(b2);
        System.out.println(b==b2);
        byte b3 = 97;
        int i = 97;
        char c = 'a';
        System.out.println(b3);
        System.out.println(b3 == i);
        System.out.println(b3 == c);
    }

    public void stringType() {
        String str = "hello";
        System.out.println(str.hashCode());

        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);           // false
        String s3 = s1.intern();
        String s4 = s1.intern();
        System.out.println(s3 == s4);           // true
    }

}
