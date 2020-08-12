package com.yuliyao.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/8/11
 */
public class InterruptDemoTest {

    private InterruptDemo interruptDemo = new InterruptDemo();

    @Test
    public void interrupt() {
        interruptDemo.interrupt();
    }
}