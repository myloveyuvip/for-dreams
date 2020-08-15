package com.yuliyao.concurrency;

import java.util.concurrent.*;

/**
 * 使用future实现一个烧水泡茶的例子
 * 烧水泡茶步骤：洗水壶、烧开水、洗茶壶、洗茶杯、拿茶叶，泡茶
 * @author yuliyao
 * @date 2020/8/15
 */
public class FutureDemo {


    public void cookTea() {

        //T1线程：洗水壶、烧开水、泡茶
        ExecutorService executorService = new ThreadPoolExecutor(2,2,0,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(2));

        //T2线程：洗茶壶、洗茶杯、拿茶叶
        FutureTask t2Task = new FutureTask(()->{
            System.out.println("洗茶壶，耗时1分钟"+System.currentTimeMillis()/1000);
            Thread.sleep(1000);
            System.out.println("洗茶杯，耗时1分钟"+System.currentTimeMillis()/1000);
            Thread.sleep(1000);
            System.out.println("拿茶叶，耗时1分钟"+System.currentTimeMillis()/1000);
            Thread.sleep(1000);
            return "上好茶叶";
        });
        FutureTask t1Task = new FutureTask(new T1Thread(t2Task));

        executorService.submit(t1Task);
        executorService.submit(t2Task);


        try {
            System.out.println("泡好茶啦！"+t1Task.get()+System.currentTimeMillis()/1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public class T1Thread implements Callable {

        private FutureTask futureTask;

        public T1Thread(FutureTask futureTask) {
            this.futureTask = futureTask;
        }


        @Override
        public Object call() throws Exception {
            System.out.println("洗水壶，耗时1分钟"+System.currentTimeMillis()/1000);
            Thread.sleep(1000);

            Object o = futureTask.get();
            System.out.println("拿到"+o+"，开始烧开水，耗时10分钟"+System.currentTimeMillis()/1000);
            Thread.sleep(10000);
            return "上好铁观音";
        }
    }


    public static void main(String[] args) {
        FutureDemo futureDemo = new FutureDemo();
        futureDemo.cookTea();

    }


}
