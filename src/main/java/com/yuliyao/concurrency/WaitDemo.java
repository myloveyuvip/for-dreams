package com.yuliyao.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuLiyao
 * @date 2020/8/11
 */
public class WaitDemo {

    private List<String> lockList = new ArrayList<>();

    public synchronized boolean getLock(String lockA, String lockB) {
        while (lockList.contains(lockA) || lockList.contains(lockB)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lockList.add(lockA);
        lockList.add(lockB);
        return true;
    }

    public synchronized boolean releaseLock(String lockA, String lockB) {
        lockList.remove(lockA);
        lockList.remove(lockB);
        notifyAll();
        return true;
    }

    public void transfer(String sender, String receiver) {
        try {
            if (getLock(sender, receiver)) {
                System.out.println(String.format("%s向%s转账，时间：%d，线程：%s", sender, receiver, System.currentTimeMillis(), Thread.currentThread().getName()));
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            releaseLock(sender, receiver);
        }

    }

}
