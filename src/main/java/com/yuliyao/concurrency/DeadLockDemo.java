package com.yuliyao.concurrency;

/**
 * @author yuliyao
 * @date 2020/8/8
 */
public class DeadLockDemo implements Runnable{


    private String first;

    private String second;

    public DeadLockDemo(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {

        synchronized (first) {

            System.out.println("i am first.--" + Thread.currentThread().getName());
            synchronized (second) {
                System.out.println("i am second.--" + Thread.currentThread().getName());
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {

        String lockA = "lockA";
        String lockB = "lockB";

        Thread thread1 = new Thread(new DeadLockDemo(lockA, lockB), "thread1");
        Thread thread2 = new Thread(new DeadLockDemo(lockB, lockA), "thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}
