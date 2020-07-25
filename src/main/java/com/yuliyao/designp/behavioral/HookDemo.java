package com.yuliyao.designp.behavioral;

/**
 * @author YuLiyao
 * @date 2020/7/24
 */
public class HookDemo {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Hook());
        System.out.println("jvm关闭时会调用hook");
    }

    public static class Hook extends Thread {

        @Override
        public void run() {
            System.out.println("I am hook!");
        }
    }

}
