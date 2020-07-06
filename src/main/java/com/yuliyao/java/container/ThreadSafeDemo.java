package com.yuliyao.java.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author YuLiyao
 * @date 2020/7/6
 */
public class ThreadSafeDemo implements Runnable {

    private int count = 0;

    private volatile int vCount = 0;


    private AtomicInteger ai=new AtomicInteger(0);

    private List<Integer> list = new ArrayList<>();
    private CopyOnWriteArrayList<Integer> cList = new CopyOnWriteArrayList<>();

    @Override
    public void run() {
        count++;
        vCount++;
        list.add(0);
        cList.add(0);
        /*//count++会出现多个线程取到同一个值进行操作
        System.out.println("count:"+count);
        System.out.println("vCount:"+vCount);
        //Atomic是原子操作
        System.out.println("AtomicInteger:"+ai.incrementAndGet());*/
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("list:"+list.size());
        System.out.println("cList:"+cList.size());
    }

    public static void main(String[] args) {
        ThreadSafeDemo threadSafeDemo = new ThreadSafeDemo();
        for (int i = 0; i < 20000; i++) {
            new Thread(threadSafeDemo).start();
        }
    }
}
