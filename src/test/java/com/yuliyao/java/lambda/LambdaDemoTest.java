package com.yuliyao.java.lambda;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yuliyao
 * @date 2020/8/4
 */
public class LambdaDemoTest {

    private LambdaDemo lambdaDemo = new LambdaDemo();

    @Test
    public void listStream() {
        lambdaDemo.listStream();
    }

    @Test
    public void testExecuteWithNew() {
        lambdaDemo.execute(new LambdaDemo.MyCallback() {
            @Override
            public void invoke() {
                System.out.println("I am callback...");
            }
        });
    }

    @Test
    public void testExecuteWithLambda() {
        lambdaDemo.execute(()-> System.out.println("I am callback..."));
    }

}