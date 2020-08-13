package com.yuliyao.concurrency;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YuLiyao
 * @date 2020/8/12
 */
public class ConditionDemo {


    private List<String> list = new ArrayList<>();


    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition notEmpty = reentrantLock.newCondition();
    private Condition notFull = reentrantLock.newCondition();


    public void enqueue(String str) {
        reentrantLock.lock();
        try {
            while (isFull()) {
                System.out.println("队列已满，等待中。。。"+System.currentTimeMillis()/1000);
                notFull.await();
            }
            list.add(str);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            reentrantLock.unlock();
        }

    }

    public void dequeue() {
        reentrantLock.lock();
        try {
            while (list.size() == 0) {


                System.out.println("队列为空，等待中。。。");
                notEmpty.await();

            }
            list.remove(0);
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
    }

}

    public boolean isFull() {
        return list.size() == 3;
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo demo = new ConditionDemo();
        demo.enqueue("1");
        demo.enqueue("2");
        demo.enqueue("3");
        Thread thread1 = new Thread(() -> demo.enqueue("4"));
        Thread thread2 = new Thread(() -> demo.dequeue());
        thread1.start();
        Thread.sleep(3000);
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(JSON.toJSONString(demo.list)+System.currentTimeMillis()/1000);

    }

}
