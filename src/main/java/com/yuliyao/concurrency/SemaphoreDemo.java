package com.yuliyao.concurrency;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 对象池
 * @author YuLiyao
 * @date 2020/8/13
 */
public class SemaphoreDemo<T,R> {

    private List<Integer> objList = new Vector<Integer>();

    private int objSize;

    private Semaphore semaphore;

    public SemaphoreDemo(int objSize) {
        this.objSize = objSize;
        for (int i = 0; i < objSize; i++) {
            objList.add(i);
        }
        semaphore = new Semaphore(objSize);
    }



    public R execute(Function<Integer, R> function) {
        Integer t = null;
        try {
            semaphore.acquire();
            t = objList.remove(0);
            return function.apply(t);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            objList.add(t);
            semaphore.release();
        }
        return null;
    }


    public static void main(String[] args) {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo(5);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                semaphoreDemo.execute(SemaphoreDemo::apply);
            }).start();

        }

    }

    private static Object apply(Object t) {
        System.out.println(t);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return t;
    }



}
