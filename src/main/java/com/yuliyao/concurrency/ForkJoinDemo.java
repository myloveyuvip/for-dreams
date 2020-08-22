package com.yuliyao.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author yuliyao
 * @date 2020/8/16
 */
public class ForkJoinDemo {

    /**
     * 用fork/join计算fibonacci
     *
     * @param num
     * @return
     */
    public Integer computeFibonacci(int num) {


        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        FibonacciTask fibonacciTask = new FibonacciTask(num);
        return forkJoinPool.invoke(fibonacciTask);
    }

    public class FibonacciTask extends RecursiveTask<Integer> {

        private Integer num;


        public FibonacciTask(Integer num) {
            this.num = num;
        }

        @Override
        protected Integer compute() {
            if (num <= 2) {
                return 1;
            }

            FibonacciTask f1 = new FibonacciTask(num - 1);
            FibonacciTask f2 = new FibonacciTask(num - 2);
            f1.fork();

            return f1.join()+f2.compute();
        }
    }

    public static void main(String[] args) {

        ForkJoinDemo forkJoinDemo = new ForkJoinDemo();
        System.out.println(forkJoinDemo.computeFibonacci(8));
    }

}
