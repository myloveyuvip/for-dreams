package com.yuliyao.java.jvm;

import org.junit.Test;

/**
 * @author yuliyao
 * @date 2020/7/12
 */
public class ClassLoaderDemoTest {

    private ClassLoaderDemo demo = new ClassLoaderDemo();

    @Test
    public void getClassLoader() {
        demo.getClassLoader();
    }
}