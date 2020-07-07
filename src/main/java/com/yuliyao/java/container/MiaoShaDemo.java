package com.yuliyao.java.container;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author YuLiyao
 * @date 2020/7/7
 */
public class MiaoShaDemo {

    private int stock = 50;

    private AtomicInteger ai = new AtomicInteger(50);


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        MiaoShaDemo miaoShaDemo = new MiaoShaDemo();
        for (int i = 0; i < 100000; i++) {
            executorService.execute(new RushBuy(miaoShaDemo));
        }
        executorService.shutdown();
        System.out.println(miaoShaDemo.stock);
        System.out.println(miaoShaDemo.ai.get());
    }

    static class RushBuy implements Runnable{

        private MiaoShaDemo miaoShaDemo;

        public RushBuy(MiaoShaDemo miaoShaDemo) {
            this.miaoShaDemo = miaoShaDemo;
        }

        @Override
        public void run() {
            synchronized (miaoShaDemo) {

                if (miaoShaDemo.stock > 0) {
                    miaoShaDemo.stock--;
                    System.out.println("恭喜你购买成功啦！当前剩余库存：" + miaoShaDemo.stock + "。当前线程:" + Thread.currentThread().getName());
                } else {
//                System.out.println("已经卖光啦！当前剩下库存：" + miaoShaDemo.stock + "。当前线程:" + Thread.currentThread().getName());

                }
            }

            //使用AtomicInteger
            /*if (miaoShaDemo.ai.getAndDecrement() > 0) {
                System.out.println("恭喜你购买成功啦！当前剩余库存：" + miaoShaDemo.ai.get() + "。当前线程:" + Thread.currentThread().getName());

            }*/
        }
    }


}
