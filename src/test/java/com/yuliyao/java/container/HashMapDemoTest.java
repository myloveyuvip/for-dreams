package com.yuliyao.java.container;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/8
 */
public class HashMapDemoTest {

    private HashMapDemo demo = new HashMapDemo();

    @Test
    public void testPutNull() {
        demo.testPutNull();
    }

    @Test
    public void testPut() {
        demo.testPut();
    }
}