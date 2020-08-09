package com.yuliyao.concurrency;

/**
 * @author yuliyao
 * @date 2020/8/8
 */
public class SynchronizedDemo {


    /**
     * synchronized关键字，非静态方法默认对象锁
     */
    public synchronized void syncKeyword() {

        System.out.println("syncKeyword..."+Thread.currentThread().getName()+"..."+System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void syncThis() {
        synchronized (this) {
            System.out.println("syncThis..."+Thread.currentThread().getName()+"..."+System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void syncObject(String lock) {
        synchronized (lock) {
            System.out.println("syncObject..."+Thread.currentThread().getName()+"..."+System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void syncClass() {
        synchronized (SynchronizedDemo.class) {
            System.out.println("syncClass..."+Thread.currentThread().getName()+"..."+System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
