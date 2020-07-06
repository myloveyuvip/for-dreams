package com.yuliyao.java.container;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/6
 */
public class VectorDemoTest {

    VectorDemo vectorDemo = new VectorDemo();

    @Test
    public void testVector() {
    }

    @Test
    public void threadSafe() {
        VectorDemo vectorDemo = new VectorDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(vectorDemo).start();
        }
    }
}