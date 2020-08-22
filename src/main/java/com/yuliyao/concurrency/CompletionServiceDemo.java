package com.yuliyao.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 实现dubbo的forking cluster，并行调用三个地址，返回最早返回的地址，然后取消剩余操作
 * @author yuliyao
 * @date 2020/8/16
 */
public class CompletionServiceDemo {


    /**
     * 获取地址的坐标
     * @param addr
     * @return
     */
    public String geoCode(String addr) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5));

        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        List<Future> futures = new ArrayList<>();
        futures.add(completionService.submit(() -> {
            Thread.sleep(new Random().nextInt(100));
            System.out.println("调用第一个地图服务商");
            return "0.0.0.0";
        }));
        futures.add(completionService.submit(() -> {
            Thread.sleep(new Random().nextInt(100));
            System.out.println("调用第二个地图服务商");
            return "1.1.1.1";
        }));
        futures.add(completionService.submit(() -> {
            Thread.sleep(new Random().nextInt(100));
            System.out.println("调用第三个地图服务商");
            return "2.2.2.2";
        }));

        String code = "";
        try {
            for (int i = 0; i < 3; i++) {
                Future<String> future = null;

                    future = completionService.take();
                    code = future.get();
                    break;
                }
            }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            for (Future future : futures) {
                future.cancel(true);
            }

        }
        executor.shutdown();
        return code;
    }

    public static void main(String[] args) {
        CompletionServiceDemo demo = new CompletionServiceDemo();
        System.out.println(demo.geoCode("fuzhou"));
    }
}
