package com.yuliyao.designp.struct;

/**
 * 代理模式，本类为静态代理
 * 应用场景：
 *  1.非功能性需求：监控、统计、鉴权、限流、事务、冥等、日志
 *  2.RPC、缓存
 *
 * @author YuLiyao
 * @date 2020/7/22
 */
public class ProxyDemo implements Animal{

    private Animal animal;

    public ProxyDemo(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void eat() {
        System.out.println("-------> let me find something eat for you.");
        animal.eat();
        System.out.println("<------- let me wash dish for you.");
    }
}
