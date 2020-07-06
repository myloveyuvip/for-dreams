package com.yuliyao.java.basis.keyword;

import org.junit.Test;

/**
 * @author YuLiyao
 * @date 2020/7/4
 */
public class KeywordTest {

    @Test
    public void test() {
        System.out.println(Keyword.staticFiled);
        Keyword keyword = new Keyword();

        Keyword.InnerClass innerClass = new Keyword.InnerClass();
        Keyword.InnerClass2 innerClass2 = keyword.new InnerClass2();
        innerClass2.setName("inner class 2");
        System.out.println(innerClass2.getName());
    }

    @Test
    public void getSingleton() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1==singleton2);
        System.out.println(null==null);
    }

}