package com.yuliyao.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者-消费者模式
 * @author yuliyao
 * @date 2020/8/15
 */
public class CustomThreadPool {


    /**
     * 线程列表
     */
    private List<Runnable> threads = new ArrayList<>();


    /**
     * 任务队列
     */
    private LinkedBlockingQueue<Runnable> taskQueue;


    public CustomThreadPool(int poolSize, LinkedBlockingQueue taskQueue) {
        this.taskQueue = taskQueue;
        for (int i = 0; i < poolSize; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            threads.add(workThread);
        }
    }

    public void execute(Runnable task) {
        taskQueue.offer(task);
    }

    public class WorkThread extends Thread{

        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(5, new LinkedBlockingQueue(10));
        for (int i = 0; i < 10; i++) {

            customThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }

    }


}
