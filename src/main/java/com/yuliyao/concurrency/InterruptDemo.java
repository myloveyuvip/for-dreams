package com.yuliyao.concurrency;

/**
 * @author YuLiyao
 * @date 2020/8/11
 */
public class InterruptDemo {

    public void interrupt() {
        Thread thread1 = new Thread(() -> {
            System.out.println("I am "+Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("isInterrupted:" + Thread.currentThread().isInterrupted());
                System.out.println("state:" + Thread.currentThread().getState());
                Thread.currentThread().interrupt();
                System.out.println("after interrupt,isInterrupted:" + Thread.currentThread().isInterrupted());
                System.out.println("after interrupt,state:" + Thread.currentThread().getState());
            }
            System.out.println("afer catch");
        }, "thread1");
        thread1.start();
        thread1.interrupt();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
