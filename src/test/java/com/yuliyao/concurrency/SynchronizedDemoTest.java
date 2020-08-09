package com.yuliyao.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yuliyao
 * @date 2020/8/9
 */
public class SynchronizedDemoTest {

    @Test
    public void syncKeyword_2instance() {

        SynchronizedDemo demo1 = new SynchronizedDemo();
        SynchronizedDemo demo2 = new SynchronizedDemo();
        new Thread(() -> demo1.syncKeyword(),"thread1").start();
        new Thread(()->demo2.syncKeyword(),"thread2").start();
    }

    @Test
    public void syncKeyword_1instance() throws InterruptedException {

        SynchronizedDemo demo1 = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> demo1.syncKeyword(), "thread1");
        Thread thread2 = new Thread(() -> demo1.syncKeyword(), "thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    @Test
    public void syncThis_2instance() {

        SynchronizedDemo demo1 = new SynchronizedDemo();
        SynchronizedDemo demo2 = new SynchronizedDemo();
        new Thread(() -> demo1.syncThis(),"thread1").start();
        new Thread(()->demo2.syncThis(),"thread2").start();
    }

    @Test
    public void syncThis_1instance() throws InterruptedException {

        SynchronizedDemo demo1 = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> demo1.syncThis(), "thread1");
        Thread thread2 = new Thread(() -> demo1.syncThis(), "thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    @Test
    public void syncObject_1instance() throws InterruptedException {

        SynchronizedDemo demo1 = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> demo1.syncObject("lock"), "thread1");
        Thread thread2 = new Thread(() -> demo1.syncObject("lock"), "thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    @Test
    public void syncClass_1instance() throws InterruptedException {

        SynchronizedDemo demo1 = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> demo1.syncClass(), "thread1");
        Thread thread2 = new Thread(() -> demo1.syncClass(), "thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    @Test
    public void syncClass_2instance() throws InterruptedException {

        SynchronizedDemo demo1 = new SynchronizedDemo();
        SynchronizedDemo demo2= new SynchronizedDemo();
        Thread thread1 = new Thread(() -> demo1.syncClass(), "thread1");
        Thread thread2 = new Thread(() -> demo2.syncClass(), "thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}