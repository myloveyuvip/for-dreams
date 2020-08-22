package com.yuliyao.concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * @author yuliyao
 * @date 2020/8/16
 */
public class CompletableFutureDemo {

    public void cookeTea() {
        CompletableFuture<Object> f1 = CompletableFuture.supplyAsync(()->{System.out.println("洗水壶，耗时1分钟"+System
                .currentTimeMillis()/1000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "干净的水壶";
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("洗茶壶，耗时1分钟" + System.currentTimeMillis() / 1000);
                Thread.sleep(1000);
                System.out.println("洗茶杯，耗时1分钟" + System.currentTimeMillis() / 1000);
                Thread.sleep(1000);
                System.out.println("拿茶叶，耗时1分钟" + System.currentTimeMillis() / 1000);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "上好茶叶";
        });

        CompletableFuture<Object> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("泡好茶啦！" + tf + System.currentTimeMillis() / 1000);
            return "上茶" + tf;
        });

        System.out.println(f3.join());

    }

    public static void main(String[] args) {
        CompletableFutureDemo demo = new CompletableFutureDemo();
        demo.cookeTea();
    }

}
