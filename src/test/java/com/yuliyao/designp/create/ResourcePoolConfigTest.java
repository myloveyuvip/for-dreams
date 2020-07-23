package com.yuliyao.designp.create;

import org.junit.Test;

/**
 * @author YuLiyao
 * @date 2020/7/21
 */
public class ResourcePoolConfigTest {

    @Test
    public void createPool() {
        ResourcePoolConfig threadPool = new ResourcePoolConfig.Builder().name("threadPool").maxIdle(10).build();
        System.out.println(threadPool);
    }

    @Test
    public void createByMethod() {
        ResourcePoolConfig threadPool = ResourcePoolConfig.builder().name("threadPool").maxIdle(10).build();
        System.out.println(threadPool);
    }

}