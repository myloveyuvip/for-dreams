package com.yuliyao.concurrency;

import org.junit.Test;

/**
 * @author YuLiyao
 * @date 2020/8/11
 */
public class InterruptDemoTest {

    private InterruptDemo interruptDemo = new InterruptDemo();

    @Test
    public void interruptedException() {
        interruptDemo.interruptedException();
    }

    @Test
    public void interrupt() {
        interruptDemo.interrupt();
    }

    @Test
    public void interrupt2() {
        interruptDemo.interrupt2();
    }
}