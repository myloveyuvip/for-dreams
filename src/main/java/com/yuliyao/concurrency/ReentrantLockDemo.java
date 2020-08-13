package com.yuliyao.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YuLiyao
 * @date 2020/8/12
 */
public class ReentrantLockDemo {

    private int balance = 0;

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void transfer(ReentrantLockDemo target, int amount) {
        while (true) {

            if (lock.tryLock()) {
                try {
                    if (target.lock.tryLock()) {

                        try {
                            target.balance += amount;
                            this.balance -= amount;
                            break;
                        } finally {
                            target.lock.unlock();
                        }
                    }

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo demo1 = new ReentrantLockDemo();
        ReentrantLockDemo demo2 = new ReentrantLockDemo();
        Thread thread1 = new Thread(() -> demo1.transfer(demo2, 100));
        Thread thread2 = new Thread(() -> demo2.transfer(demo1, 200));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("demo1 balance:" + demo1.balance);
        System.out.println("demo2 balance:" + demo2.balance);
    }

}
