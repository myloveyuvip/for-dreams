package com.yuliyao.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

/**
 * @author YuLiyao
 * @date 2020/8/14
 */
public class StampedLockDemo<K,V> {


    private Map<K,V> map = new HashMap<>();

    private StampedLock stampedLock = new StampedLock();


    public void put(K k, V v) {
        long stamp = stampedLock.writeLock();
        try {
            map.put(k, v);
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public V get(K k) {
        //乐观读
        long stamp = stampedLock.tryOptimisticRead();
        V v = map.get(k);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!stampedLock.validate(stamp)) {
            //升级成悲观锁
            stamp = stampedLock.readLock();
            try {
                v = map.get(k);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return v;
    }

    public static void main(String[] args) {
        StampedLockDemo<String, String> demo = new StampedLockDemo<>();
        demo.put("1", "a");
        new Thread(() -> System.out.println(demo.get("1"))).start();
        new Thread(()->demo.put("1","b")).start();
    }
}
