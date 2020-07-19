package com.yuliyao.java.jvm;

import org.junit.Test;

/**
 * classLoader测试类
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