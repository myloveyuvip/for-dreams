package com.yuliyao.java.basis.keyword;

/**
 * @author YuLiyao
 * @date 2020/7/4
 */
public class Singleton {

    private String name = "name";

    private Singleton(){

    }

    private static class LazyHandler{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHandler.INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
