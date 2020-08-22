package com.yuliyao.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author YuLiyao
 * @date 2020/8/11
 */
public class InterruptDemo {

    public void interruptedException() {
        Thread thread1 = new Thread(() -> {
            System.out.println("I am "+Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("isInterrupted:" + Thread.currentThread().isInterrupted());
                System.out.println("state:" + Thread.currentThread().getState());
                Thread.currentThread().interrupt();
                System.out.println("after interruptedException,isInterrupted:" + Thread.currentThread().isInterrupted());
                System.out.println("after interruptedException,state:" + Thread.currentThread().getState());
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

    public void interrupt() {
        Thread thread = new Thread(() -> {
            for (int i = 0; true; i++) {
                System.out.println(i);
            }

        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }

    public void interrupt2() {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(++i);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //false
                    System.out.println(Thread.currentThread().isInterrupted());
                    //复位
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
