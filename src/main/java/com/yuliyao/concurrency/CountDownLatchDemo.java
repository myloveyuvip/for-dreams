package com.yuliyao.concurrency;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author YuLiyao
 * @date 2020/8/14
 */
public class CountDownLatchDemo {

    /**
     * 对账
     * 1. 查询订单
     * 2. 查询物流单
     * 3. 对比差异
     * 4. 保存差异订单
     */
    public void checkAccount() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        final Set[] orders = new Set[1];
        final Set[] expressOrders = {new HashSet()};

        CountDownLatch latch = new CountDownLatch(2);

        System.out.println("begin:"+System.currentTimeMillis()/1000);
        executorService.execute(() -> {
            orders[0] = queryOrder();
            latch.countDown();
        });

        executorService.execute(()->{
            expressOrders[0] = queryExpress();
            latch.countDown();
        });
        System.out.println("before await:"+System.currentTimeMillis()/1000);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after await:"+System.currentTimeMillis()/1000);
        Set diff = diff(orders[0], expressOrders[0]);

        save(diff);
        executorService.shutdown();
    }

    private void save(Set diff) {
        System.out.println("保存差异订单："+ JSON.toJSONString(diff));

    }

    private Set diff(Set orders, Set expressOrders) {
        Set result = new HashSet();
        Sets.difference(orders, expressOrders).copyInto(result);
        return result;
    }

    private Set queryExpress() {
        Set result = new HashSet();
        result.add("b");
        result.add("c");
        result.add("d");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  result;
    }

    private Set queryOrder() {
        Set result = new HashSet();
        result.add("a");
        result.add("b");
        result.add("c");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  result;
    }

    public static void main(String[] args) {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        demo.checkAccount();
    }


}
