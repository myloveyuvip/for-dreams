package com.yuliyao.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/8/11
 */
public class WaitDemoTest {

    private WaitDemo waitDemo = new WaitDemo();

    @Test
    public void testLock() throws InterruptedException {
        Thread thread1 = new Thread(() -> waitDemo.transfer("a", "b"),"thread1");
        Thread thread2 = new Thread(() -> waitDemo.transfer("b", "a"),"thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}