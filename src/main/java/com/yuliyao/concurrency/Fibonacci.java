package com.yuliyao.concurrency;

/**
 * @author yuliyao
 * @date 2020/8/16
 */
public class Fibonacci {

    /**
     * 计算斐波那契数列的值
     *
     * @param num
     * @return
     */
    public Integer compute(int num) {

        Integer result = 0;

        if (num <= 2) {
            return 1;
        }
        return compute(num - 1) + compute(num - 2);
    }


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        Integer compute = fibonacci.compute(18);
        System.out.println(compute);
    }
}
