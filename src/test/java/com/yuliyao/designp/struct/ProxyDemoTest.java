package com.yuliyao.designp.struct;

import org.junit.Test;

/**
 * @author YuLiyao
 * @date 2020/7/22
 */
public class ProxyDemoTest {

    private Cat cat = new Cat();

    @Test
    public void testEat() {
        Animal proxyDemo = new ProxyDemo(cat);
        proxyDemo.eat();
    }


}