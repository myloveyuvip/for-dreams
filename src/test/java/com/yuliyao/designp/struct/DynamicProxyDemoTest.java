package com.yuliyao.designp.struct;

import org.junit.Test;

/**
 * @author YuLiyao
 * @date 2020/7/22
 */
public class DynamicProxyDemoTest {

    @Test
    public void testDynamicProxy() throws Throwable {
        Cat cat = new Cat();
        Animal proxy = (Animal) new DynamicProxyDemo().createProxy(cat);

        proxy.eat();

    }

}