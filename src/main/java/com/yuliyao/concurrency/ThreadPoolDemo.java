package com.yuliyao.concurrency;

import java.util.concurrent.*;

/**
 * @author yuliyao
 * @date 2020/8/15
 */
public class ThreadPoolDemo {


    public void useEexecutorsNew() {
        ExecutorService executorService =
                Executors.newFixedThreadPool(5);
        executorService.execute(()-> System.out.println(1));

    }

    public void manualNew() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 0, TimeUnit.MILLISECONDS, new
                LinkedBlockingQueue<>(5),r->new Thread(r,"myThread"));
        threadPoolExecutor.execute(()-> System.out.println(Thread.currentThread().getName()));
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) {
        ThreadPoolDemo demo = new ThreadPoolDemo();
        demo.manualNew();

//        demo.useEexecutorsNew();

    }
}
